package org.example;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static App calc;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Before
    public void setup() {
        calc = new App();
    }

    /*
    @Test
    public void whenEmptyStringReturnZero() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calc.add(""));
    }

    @Test
    public void whenOneDigitReturnThisDigit() {
        assertThat(calc.add("5")).isEqualTo(5);
    }

    @Test
    public void whenTwoDigitsReturnSum() {
        assertThat(calc.add("1 2")).isEqualTo(3);
    }

    @Test
    public void whenTwoMoreDigitsReturnSum() {
        assertThat(calc.add("1 2 3 4 5")).isEqualTo(15);
    }

    @Test
    public void whenStingHaveNoDigitReturnException() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calc.add("1 ax 3"));
    }
    */

    @Test
    public void whenSplitNotSpaceReturnSum() {
        assertThat(calc.add("1-2-3-4-5", "-")).isEqualTo(15);
    }

    @Test
    public void whenSplitHasNotCarrentSpliter() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> calc.add("1 2 3 5", ","));
    }

    @Test
    public void whenStringHasSpliterInStartReturnSum() {
        assertThat(calc.add("//* 12*12", ";")).isEqualTo(24);
    }

    @Test
    public void whenIgnoredMinusReturnSum() {
        assertThat(calc.add("//* 12*12*-12*-12*5", ";")).isEqualTo(29);
    }

    @After
    public static void finish() {
        System.out.println("Finish");
    }

}

