package com.shitikov.task4_1.parser;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;

public class CustomArrayParser {

    public CustomArray parseArray(String data) throws ProjectException {
        if (data.isEmpty() || data.equals("[]")) {
            throw new ProjectException("No data");
        }
        String[] dataArray = data.replace("[", "").replace("]", "")
                .split("\\,?\\s+");

        int[] numbers = new int[dataArray.length];
        for (int i = 0; i < dataArray.length; i++) {
            try {
                numbers[i] = Integer.parseInt(dataArray[i]);
            } catch (NumberFormatException e) {
                throw new ProjectException("Incorrect parameter");
            }

        }
        return new CustomArray(numbers);
    }
}
