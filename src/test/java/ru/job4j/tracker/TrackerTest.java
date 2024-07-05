package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.Delete;
import ru.job4j.tracker.action.FindById;
import ru.job4j.tracker.action.FindByName;
import ru.job4j.tracker.action.Replace;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindById() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll().get(0);
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
       MemTracker tracker = new MemTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result.get(1).getName()).isEqualTo(second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        tracker.delete(1000);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
    }

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Replace replaceAction = new Replace(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

    @Test
    public void whenItemIsNotReplaced() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        Replace replaceAction = new Replace(output);

        Input input = mock(Input.class);
        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Редактирование заявки ===" + ln
                        + "Ошибка замены заявки." + ln
        );
    }

    @Test
    public void whenItemWasDeletedSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        String deletedName = "Item";
        Delete deleteAction = new Delete(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(deletedName);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Заявка удалена успешно." + ln
        );
    }

    @Test
    public void whenItemIsNotDeleted() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        Delete deleteAction = new Delete(output);
        Input input = mock(Input.class);
        deleteAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки." + ln
        );
    }

    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        FindById find = new FindById(output);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + tracker.findById(1) + ln
        );
    }

    @Test
    public void whenItemIsNotFindById() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        FindById find = new FindById(output);
        Input input = mock(Input.class);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: 0 не найдена." + ln
        );
    }

    @Test
    public void whenItemWasFindByNameSuccessfully() {
        Output output = new Stub();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item"));
        FindByName find = new FindByName(output);
        String findName = "Item";
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(findName);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        List<Item> list = tracker.findByName(findName);
        StringBuilder expected = new StringBuilder("=== Вывод заявок по имени ===" + ln);
        for (Item item : list) {
            expected.append(item).append(ln);
        }
        assertThat(output.toString()).isEqualTo(expected.toString());
    }
}