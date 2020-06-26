package com.shitikov.task4_2.comparator;

import java.util.Comparator;

public class MaxComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] arr1, int[] arr2) {
        int max1 = maximumOfArray(arr1);
        int max2 = maximumOfArray(arr2);

        if (max1 > max2) {
            return 1;
        } else if (max1 < max2) {
            return -1;
        }
        return 0;
    }

    private int maximumOfArray(int[] arr) {
        int maxValue = 0;

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (maxValue < element) {
                maxValue = element;
            }
        }
        return maxValue;
    }
}
