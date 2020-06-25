package com.shitikov.task4_1.service;

import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;
import org.jetbrains.annotations.NotNull;

public class ArraySearchServiceOpt {
    private static final int MAX_FIBONACCI_INDEX = 40;
    private static final int MAX_THREE_DIGIT = 999;
    private static final int MIN_THREE_DIGIT = 100;

    private interface SearchCondition {
        boolean isEqual(int number);
    }

    public int binarySearch(@NotNull CustomArray customArray, int start, int end, int numberToSearch) {
        int firstIndex = (start > -1) ? start : 0;
        int lastIndex = (end <= customArray.length()) ? end - 1 : customArray.length() - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

            if (customArray.getElementOpt(middleIndex).getAsInt() == numberToSearch) {
                return middleIndex;
            } else if (customArray.getElementOpt(middleIndex).getAsInt() < numberToSearch) {
                firstIndex = middleIndex + 1;
            } else if (customArray.getElementOpt(middleIndex).getAsInt() > numberToSearch) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public int binarySearchUnsortArray(@NotNull CustomArray customArray, int start, int end, int numberToSearch) throws ProjectException {
        ArraySortService sortService = new ArraySortService();
        sortService.sortInsertion(customArray);
        return binarySearch(customArray, start, end, numberToSearch);
    }

    public int maxValue(@NotNull CustomArray customArray) {
        int maxValue = 0;

        for (int i = 0; i < customArray.length(); i++) {
            int element = customArray.getElementOpt(i).getAsInt();
            if (maxValue < element) {
                maxValue = element;
            }
        }
        return maxValue;
    }

    public int minValue(@NotNull CustomArray customArray) {
        int minValue = 0;

        for (int i = 0; i < customArray.length(); i++) {
            int element = customArray.getElementOpt(i).getAsInt();
            if (minValue > element) {
                minValue = element;
            }
        }
        return minValue;
    }

    /*
    if need to find max value - parameter "findMax" is true, if min value - false
     */

    public int maxOrMinValue(@NotNull CustomArray customArray, boolean findMax) {
        int result = 0;

        for (int i = 0; i < customArray.length(); i++) {
            int element = customArray.getElementOpt(i).getAsInt();
            if (findMax ? (result < element) : (result > element)) {
                result = element;
            }
        }
        return result;
    }

    public int[] primeNumbers(@NotNull CustomArray customArray) {
        SearchCondition condition = this::isPrime;
        return findNumbers(customArray, condition);
    }

    public int[] fibonacciNumbers(@NotNull CustomArray customArray) {
        SearchCondition condition = this::isFibonacci;
        return findNumbers(customArray, condition);
    }

    public int[] threeDigitNumbers(@NotNull CustomArray customArray) {
        SearchCondition condition = this::hasDifferentDigits;
        return findNumbers(customArray, condition);
    }

    private int[] findNumbers(CustomArray customArray, SearchCondition searchCondition) {

        int length = customArray.length();
        int[] temp = new int[length];

        int numberOfPrimes = 0;
        int tempIndex = 0;

        for (int i = 0; i < length; i++) {
            int arrayElement = customArray.getElementOpt(i).getAsInt();

            if (searchCondition.isEqual(arrayElement)) {
                temp[tempIndex] = arrayElement;
                tempIndex++;
                numberOfPrimes++;
            }
        }
        if (numberOfPrimes > 0) {
            int[] result = fillArray(temp, numberOfPrimes);
            return result;
        } else {
            return new int[0];
        }
    }

    private boolean isPrime(int number) {
        boolean result = true;

        if (number == 2) {
            return result;
        }

        if (number == 1 || number % 2 == 0) {
            result = false;
        } else {
            int divider = 3;
            while (divider <= Math.sqrt(number)) {
                if (number % divider == 0) {
                    result = false;
                    break;
                }
                divider += 2;
            }
        }
        return result;
    }

    private boolean isFibonacci(int number) {
        int fibonacciNumber = 0;

        for (int i = 0; i < MAX_FIBONACCI_INDEX && fibonacciNumber < number; i++) {
            fibonacciNumber = calculateFibonacci(i);

            if (number == fibonacciNumber) {
                return true;
            }
        }
        return false;
    }

    private int calculateFibonacci(int index) {
        return (int) ((Math.pow((1 + Math.sqrt(5))/2, index) -
                Math.pow((1 - Math.sqrt(5))/2, index))/Math.sqrt(5));
    }

    private boolean hasDifferentDigits(int number) {
        if (Math.abs(number) >= MIN_THREE_DIGIT && Math.abs(number) <= MAX_THREE_DIGIT) {
            int one = number % 10;
            int ten = (number / 10) % 10;
            int hundred = number / 100;

            if (one != ten && one != hundred && ten != hundred) {
                return true;
            }
        }
        return false;
    }

    private int[] fillArray(int[] sourceArray, int length) {
        int[] result = new int[length];

        for (int i = 0; i < result.length; i++) {
            result[i] = sourceArray[i];
        }
        return result;
    }
}
