package org.example;

import org.example.annotations.CustomAfter;
import org.example.annotations.CustomBefore;
import org.example.annotations.CustomTest;

public class AppTest {

    public static App calc;

    @CustomBefore
    public static void init() {
        calc = new App();
        System.out.println("Start testing");
    }

    @CustomTest
    public void whenSplitHasNotCarrentSpliter() {
        CustomAsserts.assertException(calc.add("1 2 3 5", ","));
    }

    @CustomTest
    public void whenStringHasSpliterInStartReturnSum() {
        CustomAsserts.assertEqual(calc.add("//* 12*12", ";"), 24);
    }


    @CustomTest
    public void whenIgnoredMinusReturnSum() {
        CustomAsserts.assertEqual(calc.add("//* 12*12*-12*-12*5", ";"), 29);
    }

    @CustomAfter
    public static void finish() {
        System.out.println("Finish testing");
    }
}
