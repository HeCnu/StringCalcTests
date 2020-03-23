package ru.liga.customjunit;

import java.lang.reflect.Method;

public class CustomAsserts {

    private static String value;

    public CustomAsserts(String valueOf) {
        this.value = valueOf;
    }

    public boolean assertEquals(String string) {
        if (this.value.equals(string))
            System.out.println("Test passed");
        else
            System.out.println("Expected - " + string + ", but got value - " + value + ".");
        return this.value.equals(string);
    }

    public boolean assertTrue() {
        if (this.value.equals(String.valueOf("true")))
            System.out.println("Test passed");
        else
            System.out.println("Expected - " + true + ", but got value - " + value + ".");
        return this.value.equals(String.valueOf("true"));
    }

    public boolean assertNotNull() {
        if (!this.value.equals(String.valueOf("null")))
            System.out.println("Test passed");
        else
            System.out.println(" Got value - " + null + ".");
        return !this.value.equals(String.valueOf("null"));
    }

    public static CustomAsserts assertThat(Object resulfOfSomeFunction) {
        CustomAsserts customAsserts = new CustomAsserts(String.valueOf(resulfOfSomeFunction));
        return customAsserts;
    }

}
