package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {
    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplace() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item = new Item("item");
        sqlTracker.add(item);
        assertThat(sqlTracker.replace(item.getId(), item)).isTrue();
    }

    @Test
    public void whenDelete() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item = new Item("item");
        sqlTracker.delete(1);
        assertThat(sqlTracker.findByName(item.getName())).isEmpty();
    }

    @Test
    public void whenFindAll() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        List<Item> items = new ArrayList<>();
        Item item = new Item("item");
        sqlTracker.add(item);
        items.add(item);
        assertThat(sqlTracker.findAll()).isEqualTo(items);
    }

    @Test
    public void whenFindByName() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        List<Item> items = new ArrayList<>();
        Item item = new Item("item");
        sqlTracker.add(item);
        items.add(item);
        assertThat(sqlTracker.findByName(item.getName())).isEqualTo(items);
    }

    @Test
    public void whenFindById() {
        SqlTracker sqlTracker = new SqlTracker(connection);
        Item item = new Item("item");
        sqlTracker.add(item);
        sqlTracker.findById(1);
        assertThat(sqlTracker.findById(item.getId())).isEqualTo(item);
    }
}