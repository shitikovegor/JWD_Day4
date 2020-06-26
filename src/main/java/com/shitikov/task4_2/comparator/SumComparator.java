package com.shitikov.task4_2.comparator;

import java.util.Comparator;

public class SumComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] arr1, int[] arr2) {
        int sum1 = sumOfArray(arr1);
        int sum2 = sumOfArray(arr2);

        if (sum1 > sum2) {
            return 1;
        } else if (sum1 < sum2) {
            return -1;
        }
        return 0;
    }

    private int sumOfArray(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
