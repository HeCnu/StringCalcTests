package ru.liga.customjunit.runner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ru.liga.customjunit.annotations.CustomAfter;
import ru.liga.customjunit.annotations.CustomBefore;
import ru.liga.customjunit.annotations.CustomTest;

public class TestRunner {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void runTests(String packageName) throws InvocationTargetException, IllegalAccessException {
        Set<Class<?>> classes = ParserClasses.parse(packageName);
        for (Class<?> c : classes) {
            System.out.println("[ Run tests with class "+ c.getName() + " ]");
            runTest(c);
        }
    }

    public void runTest(Class test) throws InvocationTargetException, IllegalAccessException {
        Method[] allMethods = test.getDeclaredMethods();
        List<Method> sortedMethods = getMethods(allMethods);
        for (Method method : sortedMethods) {
            executeMethod(test, method);
        }
    }

    private List<Method> getMethods(Method[] allMethods) {
        List<Method> sortedMethods = new ArrayList<>();
        Class[] classes = {CustomBefore.class, CustomTest.class, CustomAfter.class};
        for (Class classMethod: classes) {
            for (Method method: allMethods) {
                if (method.isAnnotationPresent(classMethod))
                    sortedMethods.add(method);
            }
        }
        return sortedMethods;
    }

    private void executeMethod(Class test, Method method) throws InvocationTargetException, IllegalAccessException {
        try {
            method.invoke(test.newInstance());
            if (method.isAnnotationPresent(CustomTest.class))
                System.out.println(ANSI_GREEN + method.getName() + " - Success" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + method.getName() + " - NOT Success" + ANSI_RESET);
            e.printStackTrace();
        }
    }
}
