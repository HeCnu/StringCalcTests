package ru.liga.customjunit.tests;

import ru.liga.customjunit.App;
import ru.liga.customjunit.CustomAsserts;
import ru.liga.customjunit.annotations.CustomAfter;
import ru.liga.customjunit.annotations.CustomBefore;
import ru.liga.customjunit.annotations.CustomTest;

public class AppTest2 {

    public static App calc;

    @CustomBefore
    public static void init2() {
        calc = new App();
        System.out.println("Start testing");
    }

    @CustomTest
    public void whenSplitHasNotCarrentSpliter2() {
        CustomAsserts.assertThat(calc.add("//. 1.1.2.5", ",")).assertNotNull();
    }

    @CustomTest
    public void whenStringHasSpliterInStartReturnSum2() {
        CustomAsserts.assertThat(calc.add("//* 12*12", ";")).assertEquals("24");
    }


    @CustomTest
    public void whenIgnoredMinusReturnSum2() {
        CustomAsserts.assertThat(calc.add("//* 12*12*-12*-12*5", ";")).assertEquals("29");
    }

    @CustomAfter
    public static void finish2() {
        System.out.println("Finish testing");
    }
}
