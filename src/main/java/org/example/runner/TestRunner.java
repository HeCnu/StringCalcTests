package org.example.runner;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.example.annotations.CustomAfter;
import org.example.annotations.CustomBefore;
import org.example.annotations.CustomTest;

public class TestRunner {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void runTests(Object test) throws InvocationTargetException, IllegalAccessException {
        Method[] allMethods = test.getClass().getDeclaredMethods();
        List<Method> sortedMethods = new ArrayList<>();
        Class[] classes = {CustomBefore.class, CustomTest.class, CustomAfter.class};
        for (Class classMethod: classes) {
            for (Method method: allMethods) {
                if (method.isAnnotationPresent(classMethod))
                    sortedMethods.add(method);
            }
        }
        for (Method method : sortedMethods) {
            executeMethod(test, method);
        }
    }

    private void executeMethod(Object test, Method method) throws InvocationTargetException, IllegalAccessException {
        try {
            method.invoke(test);
            if (method.isAnnotationPresent(CustomTest.class))
                System.out.println(ANSI_GREEN + method.getName() + " - Success" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + method.getName() + " - NOT Success" + ANSI_RESET);
        }
    }
}
