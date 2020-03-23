package ru.liga.customjunit;

import com.google.common.base.Splitter;
import ru.liga.customjunit.runner.TestRunner;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestRunner testRunner = new TestRunner();
        testRunner.runTests("ru.liga.customjunit.tests");
    }

    public int add(String numbers, String delimiter) {

        String[] tempArr = defineDelimiter(numbers, delimiter);
        numbers = tempArr[0];
        delimiter = tempArr[1];

        int result = 0;
        Iterable<String> numbersArray;
        try {
            numbersArray = Splitter.on(delimiter).split(numbers);
        } catch (Exception ex) {
            throw new RuntimeException("String hasn't current spliter");
        }

        for (String numberStr : numbersArray) {
            try {
                if(!numberStr.contains("-")) {
                    result += Integer.parseInt(numberStr);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        return result;
    }

    public boolean returnTrueMethod() {
        return true;
    }

    private String[] defineDelimiter(String numbers, String delimiter) {
        String[] array = new String[2];

        if(hasDelimiterMarker(numbers)) {
            delimiter = String.valueOf(numbers.charAt(2));
            numbers = numbers.substring(4);
        }
        array[0] = numbers;
        array[1] = delimiter;

        return array;
    }

    private boolean hasDelimiterMarker(String token) {
        return token.startsWith("//");
    }
}
