package ru.job4j.tracker;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemSorterTest {

    @Disabled
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kris", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(2, "Victor", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(3, "Natali", LocalDateTime.parse("2024-04-06T23:34:33"))
        );
        items.sort(new ItemAscByName());

        List<Item> expected = Arrays.asList(
                new Item(1, "Kris", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(3, "Natali", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(2, "Victor", LocalDateTime.parse("2024-04-06T23:34:33"))
        );
        assertThat(items).isEqualTo(expected);
    }

    @Disabled
    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kris", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(2, "Victor", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(3, "Natali", LocalDateTime.parse("2024-04-06T23:34:33"))
        );
        items.sort(new ItemDescByName());

        List<Item> expected = Arrays.asList(
                new Item(2, "Victor", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(3, "Natali", LocalDateTime.parse("2024-04-06T23:34:33")),
                new Item(1, "Kris", LocalDateTime.parse("2024-04-06T23:34:33"))
        );
        assertThat(items).isEqualTo(expected);
    }

}
