package com.shitikov.task4_1.parser;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;

public class CustomArrayParser {

    public CustomArray parseArray(String input) throws ProjectException {
        if (input.isEmpty()) {
            throw new ProjectException("No data");
        }
        String[] numbers = input.split("\\,?\\s+");
        CustomArray customArray = parseArray(numbers);

        return customArray;
    }

    public CustomArray parseArray(String[] data) throws ProjectException {
        try {
            int[] numbers = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                numbers[i] = Integer.parseInt(data[i]);
            }
            return new CustomArray(numbers);
        } catch (NumberFormatException e) {
            throw new ProjectException("Incorrect format of number");
        }
    }
}
