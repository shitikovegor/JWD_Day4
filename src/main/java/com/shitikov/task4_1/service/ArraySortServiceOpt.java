package com.shitikov.task4_1.service;

import com.shitikov.task4_1.entity.CustomArray;

public class ArraySortServiceOpt {

    public void sortSelectionOpt(CustomArray customArray) {
        int length = customArray.length();

        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (customArray.getElementOpt(j).getAsInt() < customArray.getElementOpt(minIndex).getAsInt()) {
                    minIndex = j;
                }
            }
            swapOpt(customArray, i, minIndex);
        }
    }

    public void sortShell(CustomArray customArray) {
        int length = customArray.length();
        int interval = length / 2;

        while (interval > 0) {
            for (int i = 0; i < length; i++) {
                for (int j = i - interval; j >= 0; j -= interval) {

                    if (customArray.getElementOpt(j).getAsInt() > customArray.getElementOpt(j + interval).getAsInt()) {
                        swapOpt(customArray, j, j + interval);
                    }
                }
            }
            interval = interval / 2;
        }
    }

    public void sortInsertion(CustomArray customArray) {
        int length = customArray.length();

        for (int i = 1; i < length; i++) {
            int value = customArray.getElementOpt(i).getAsInt();
            int j = i - 1;

            while (j >= 0 && customArray.getElementOpt(j).getAsInt() > value) {
                customArray.setElement(j+1, customArray.getElementOpt(j).getAsInt());
                j--;
            }
            customArray.setElement(j+1, value);
        }
    }

    private void swapOpt(CustomArray customArray, int index1, int index2) {
        int temp = customArray.getElementOpt(index1).getAsInt();
        customArray.setElement(index1, customArray.getElementOpt(index2).getAsInt());
        customArray.setElement(index2, temp);
    }
}
