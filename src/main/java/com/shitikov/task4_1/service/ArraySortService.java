package com.shitikov.task4_1.service;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;

public class ArraySortService {

    public void sortSelection(CustomArray customArray) throws ProjectException {
        int length = customArray.length();

        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (customArray.getElement(j) < customArray.getElement(minIndex)) {
                    minIndex = j;
                }
            }
            swap(customArray, i, minIndex);
        }
    }

    public void sortShell(CustomArray customArray) throws ProjectException {
        int length = customArray.length();
        int interval = length / 2;

        while (interval > 0) {
            for (int i = 0; i < length; i++) {
                for (int j = i - interval; j >= 0; j -= interval) {

                    if (customArray.getElement(j) > customArray.getElement(j + interval)) {
                        swap(customArray, j, j + interval);
                    }
                }
            }
            interval = interval / 2;
        }
    }

    public void sortInsertion(CustomArray customArray) throws ProjectException {
        int length = customArray.length();

        for (int i = 1; i < length; i++) {
            int value = customArray.getElement(i);
            int j = i - 1;

            while (j >= 0 && customArray.getElement(j) > value) {
                customArray.setElement(j+1, customArray.getElement(j));
                j--;
            }
            customArray.setElement(j+1, value);
        }
    }

    private void swap(CustomArray customArray, int index1, int index2) throws ProjectException {
        int temp = customArray.getElement(index1);
        customArray.setElement(index1, customArray.getElement(index2));
        customArray.setElement(index2, temp);
    }

}
