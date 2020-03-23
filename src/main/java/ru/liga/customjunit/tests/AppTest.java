package ru.liga.customjunit.tests;

import ru.liga.customjunit.App;
import ru.liga.customjunit.CustomAsserts;
import ru.liga.customjunit.annotations.CustomAfter;
import ru.liga.customjunit.annotations.CustomBefore;
import ru.liga.customjunit.annotations.CustomTest;

public class AppTest {

    public static App calc;

    @CustomBefore
    public static void init() {
        calc = new App();
        System.out.println("Start testing");
    }

    @CustomTest
    public void whenSplitHasNotCarrentSpliter() {
        CustomAsserts.assertThat(calc.returnTrueMethod()).assertTrue();
    }

    @CustomTest
    public void whenStringHasSpliterInStartReturnSum() {
        CustomAsserts.assertThat(calc.add("//* 12*12", ";")).assertEquals("24");
    }


    @CustomTest
    public void whenIgnoredMinusReturnSum() {
        CustomAsserts.assertThat(calc.add("//* 12*12*-12*-12*5", ";")).assertEquals("29");
    }

    @CustomAfter
    public static void finish() {
        System.out.println("Finish testing");
    }
}
