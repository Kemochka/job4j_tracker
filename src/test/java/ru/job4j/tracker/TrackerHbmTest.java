package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenReplace() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("item");
            Item item1 = new Item("item1");
            tracker.add(item);
            int id = item.getId();
            item1.setId(id);
            tracker.replace(id, item1);
            Item result = tracker.findById(id);
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenDelete() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item(1, "item", LocalDateTime.now());
            tracker.add(item);
            tracker.delete(1);
            assertThat(tracker.findByName(item.getName())).isEmpty();
        }
    }

    @Test
    public void whenFindAll() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            tracker.add(item);
            List<Item> itemList = new ArrayList<>();
            itemList.add(item);
            assertThat(tracker.findAll()).isEqualTo(itemList);
        }
    }

    @Test
    public void findByName() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("Item");
            tracker.add(item);
            List<Item> items = tracker.findByName(item.getName());
            assertThat(items).hasSize(items.size());
            assertThat(items.get(0)).isEqualTo(item);
        }
    }

    @Test
    public void findById() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item(1, "item1");
            tracker.add(item);
            assertThat(tracker.findById(item.getId())).isEqualTo(item);
        }
    }
}
