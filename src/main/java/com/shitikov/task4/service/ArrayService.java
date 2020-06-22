package com.shitikov.task4.service;

import com.shitikov.task4.entity.CustomArray;

public class ArrayService {

    public void sortSelection(CustomArray customArray) {
        int [] arrayForSort = customArray.getArray();

        for (int i = 0; i < arrayForSort.length; i++) {
            int minIndex = i;
            for (int j = i; j < arrayForSort.length; j++) {
                if (arrayForSort[j] < arrayForSort[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arrayForSort, i, minIndex);
        }
    }

    public void sortShell(CustomArray customArray) {
        int[] arrayForSort = customArray.getArray();
        int interval = arrayForSort.length / 2;

        while (interval > 0) {
            for (int i = 0; i < arrayForSort.length; i++) {
                for (int j = i - interval; j >= 0; j -= interval) {

                    if (arrayForSort[j] > arrayForSort[j + interval]) {
                        swap(arrayForSort, j, j + interval);
                    }
                }
            }
            interval = interval / 2;
        }
    }

    public void sortInsertion(CustomArray customArray) {
        int[] arrayForSort = customArray.getArray();

        for (int i = 1; i < arrayForSort.length; i++) {
            int value = arrayForSort[i];
            int j = i - 1;

            while (j >= 0 && arrayForSort[j] > value) {
                arrayForSort[j+1] = arrayForSort[j];
                j--;
            }
            arrayForSort[j+1] = value;
        }
    }

    public int binarySearchUnsort(CustomArray customArray,int start, int end, int numberToSearch) {
        sortInsertion(customArray);
        return binarySearch(customArray, start, end, numberToSearch);
    }

    public int binarySearch(CustomArray customArray, int start, int end, int numberToSearch) {

        int[] arrayForSearch = customArray.getArray();

        int firstIndex = start;
        int lastIndex = end - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

            if (arrayForSearch[middleIndex] == middleIndex) {
                return middleIndex;
            } else if (arrayForSearch[middleIndex] < numberToSearch) {
                firstIndex = middleIndex + 1;
            } else if (arrayForSearch[middleIndex] > numberToSearch) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
