package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

class ValidateTest {
    @Test
    void whenInvalidInput() {
        Output out = new Stub();
        Input in = new Mock(
                new String[] {"one", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenInvalidInput1() {
        Output out = new Stub();
        Input in = new Mock(
                new String[] {"3"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenInvalidInput2() {
        Output out = new Stub();
        Input in = new Mock(
                new String[] {"0", "1", "2", "3"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(0);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(3);
    }

    @Test
    void whenInvalidInput3() {
        Output out = new Stub();
        Input in = new Mock(
                new String[] {"-3"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-3);
    }
}