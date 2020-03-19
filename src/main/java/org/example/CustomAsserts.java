package org.example;

import java.lang.reflect.Method;

public class CustomAsserts {
    public static void assertEqual(Object object1, Object object2) {
        if (!object1.equals(object2)) {
            throw new RuntimeException();
        }
    }

    public static void assertException(Object object) {
        try {
            object.equals(null);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
