package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemSorterTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kris"),
                new Item(2, "Victor"),
                new Item(3, "Natali")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Kris"),
                new Item(3, "Natali"),
                new Item(2, "Victor")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kris"),
                new Item(2, "Victor"),
                new Item(3, "Natali")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "Victor"),
                new Item(3, "Natali"),
                new Item(1, "Kris")
        );
        assertThat(items).isEqualTo(expected);
    }
}
