package com.shitikov.task4_2.service;

import com.shitikov.task4_1.exception.ProjectException;
import com.shitikov.task4_2.enumeration.SortingOrder;

import java.util.Comparator;

public class JaggedArrayService {

    public void sortBubble(int[][] arrayForSort, Comparator<int[]> comparator, SortingOrder sortingOrder) throws ProjectException {
        if (arrayForSort == null || comparator == null || sortingOrder == null) {
            throw new ProjectException("Parameter is incorrect");
        }

        for (int i = 0; i < arrayForSort.length; i++) {
            for (int j = arrayForSort.length - 1; j > i; j--) {

                if (comparator.compare(arrayForSort[j - 1], arrayForSort[j]) == sortingOrder.getOrder()) {

                    int[] temp = arrayForSort[j - 1];
                    arrayForSort[j - 1] = arrayForSort[j];
                    arrayForSort[j] = temp;
                }
            }
        }
    }
}
