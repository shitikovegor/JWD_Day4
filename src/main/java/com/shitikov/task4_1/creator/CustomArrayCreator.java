package com.shitikov.task4_1.creator;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_1.parser.CustomArrayParser;
import com.shitikov.task4_1.reader.CustomArrayReader;

public class CustomArrayCreator {
    public CustomArray createRandomArray() {
        CustomArray customArray = new CustomArray();

        for (int i = 0; i < customArray.length(); i++) {
            customArray.setElement(i, (int) (Math.random() * 100));
        }
        return customArray;
    }

    public CustomArray createArrayFromFile(String fileName) throws ProjectException {
        CustomArrayReader reader = new CustomArrayReader();
        CustomArrayParser parser = new CustomArrayParser();

        String data = reader.readFileLine(fileName);
        CustomArray customArray = parser.parseArray(data);

        return customArray;
    }

    public CustomArray createArrayFromConsole(String[] consoleArgs) throws ProjectException {
        CustomArrayParser parser = new CustomArrayParser();

        return parser.parseArray(consoleArgs);
    }
}
