package ru.job4j.tracker;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(HbmTracker.class);

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        Item result = null;
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
            result = item;
        } catch (Exception e) {
            LOGGER.error("Exception during add item", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.createQuery("update Item set name = :fName where id = fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            LOGGER.error("Exception during update item", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("delete from Item where id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error("Exception during delete item", e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> items = new ArrayList<>();
        try {
            session.beginTransaction();
            items = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error("Exception during find all items", e);
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> items = new ArrayList<>();
        try {
            session.beginTransaction();
            var query = session.createQuery("from Item where name = :key", Item.class)
                    .setParameter("key", key);
            items = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error("Exception during find item by name", e);
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item result = null;
        try {
            session.beginTransaction();
            result = session.createQuery("from Item as i where i.id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            LOGGER.error("Exception during find item by id", e);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
