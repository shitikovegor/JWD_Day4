package com.shitikov.task4_1.service;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;

import static com.shitikov.task4_1.service.ArraySearchService.ERROR_MESSAGE;

public class ArraySortService {

    public void sortSelection(CustomArray customArray) throws ProjectException {
        if (customArray == null) {
            throw new ProjectException(ERROR_MESSAGE);
        }

        int length = customArray.length();

        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (customArray.get(j).getAsInt() < customArray.get(minIndex).getAsInt()) {
                    minIndex = j;
                }
            }
            swap(customArray, i, minIndex);
        }
    }

    public void sortShell(CustomArray customArray) throws ProjectException {
        if (customArray == null) {
            throw new ProjectException(ERROR_MESSAGE);
        }

        int length = customArray.length();
        int interval = length / 2;

        while (interval > 0) {
            for (int i = 0; i < length; i++) {
                for (int j = i - interval; j >= 0; j -= interval) {

                    if (customArray.get(j).getAsInt() > customArray.get(j + interval).getAsInt()) {
                        swap(customArray, j, j + interval);
                    }
                }
            }
            interval = interval / 2;
        }
    }

    public void sortInsertion(CustomArray customArray) throws ProjectException {
        if (customArray == null) {
            throw new ProjectException(ERROR_MESSAGE);
        }

        int length = customArray.length();

        for (int i = 1; i < length; i++) {
            int value = customArray.get(i).getAsInt();
            int j = i - 1;

            while (j >= 0 && customArray.get(j).getAsInt() > value) {
                customArray.set(j + 1, customArray.get(j).getAsInt());
                j--;
            }
            customArray.set(j + 1, value);
        }
    }

    private void swap(CustomArray customArray, int index1, int index2) {
        int temp = customArray.get(index1).getAsInt();
        customArray.set(index1, customArray.get(index2).getAsInt());
        customArray.set(index2, temp);
    }
}
