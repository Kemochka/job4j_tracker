package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenCompatorDescByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByName() {
        Comparator<Job> comparator = new JobByName();
        int rsl = comparator.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByPriority() {
        Comparator<Job> comparator = new JobByPriority();
        int rsl = comparator.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> comparator = new JobDescByName();
        int rsl = comparator.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> comparator = new JobDescByPriority();
        int rsl = comparator.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorByNameAndDescByPrority() {
        Comparator<Job> cmpNamePriority = new JobByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompatorDescByNameAndByPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Kristina", 1),
                new Job("Victor", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}