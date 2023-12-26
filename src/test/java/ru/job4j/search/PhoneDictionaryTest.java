package ru.job4j.search;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Kris", "Kem", "6789", "Perm")
        );
        ArrayList<Person> persons = phones.find("Petr");
        ArrayList<Person> emptyList = new ArrayList<>();
        assertThat(persons).isEqualTo(emptyList);
    }
}