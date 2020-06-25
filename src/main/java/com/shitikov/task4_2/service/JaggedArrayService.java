package com.shitikov.task4_2.service;

public class JaggedArrayService {



    public void sortBubble(int[] arrayForSort) {

        for (int i = arrayForSort.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (arrayForSort[j] > arrayForSort[j+1]) {
                    int temp = arrayForSort[j];
                    arrayForSort[j] = arrayForSort[j+1];
                    arrayForSort[j+1] = temp;
                }
            }
        }
    }
}
