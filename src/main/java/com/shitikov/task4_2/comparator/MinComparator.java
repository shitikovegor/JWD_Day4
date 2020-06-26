package com.shitikov.task4_2.comparator;

import java.util.Comparator;

public class MinComparator implements Comparator<int[]> {
    
    @Override
    public int compare(int[] arr1, int[] arr2) {
        int min1 = minimumOfArray(arr1);
        int min2 = minimumOfArray(arr2);

        if (min2 < min1) {
            return 1;
        } else if (min2 > min1) {
            return -1;
        }
        return 0;
    }
    
    private int minimumOfArray(int[] arr) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (minValue > element) {
                minValue = element;
            }
        }
        return minValue;
    }
}
