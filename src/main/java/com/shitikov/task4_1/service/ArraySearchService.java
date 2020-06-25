package com.shitikov.task4_1.service;

import org.jetbrains.annotations.NotNull;
import com.shitikov.task4_1.entity.CustomArray;
import com.shitikov.task4_1.exception.ProjectException;

public class ArraySearchService {
    private static final int MAX_FIBONACCI_INDEX = 40;

    public int binarySearch(@NotNull CustomArray customArray, int start, int end, int numberToSearch) throws ProjectException {
        int firstIndex = (start > -1) ? start : 0;
        int lastIndex = (end <= customArray.length()) ? end - 1 : customArray.length() - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;

            if (customArray.getElement(middleIndex) == numberToSearch) {
                return middleIndex;
            } else if (customArray.getElement(middleIndex) < numberToSearch) {
                firstIndex = middleIndex + 1;
            } else if (customArray.getElement(middleIndex) > numberToSearch) {
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

    public int[] findPrimeNumbers(@NotNull CustomArray customArray) throws ProjectException {
        return findPrimeOrFibonacciNumbers(customArray, true);
    }

    public int[] findFibonacciNumbers(CustomArray customArray) throws ProjectException {
        return findPrimeOrFibonacciNumbers(customArray, false);
    }

    private int[] findPrimeOrFibonacciNumbers(CustomArray customArray, boolean primeOrFibonacci) throws ProjectException {

        int length = customArray.length();
        int[] temp = new int[length];

        int numberOfPrimes = 0;
        int tempIndex = 0;

        for (int i = 0; i < length; i++) {
            int arrayElement = customArray.getElement(i);

            if (primeOrFibonacci ? isPrime(arrayElement) : isFibonacci(arrayElement)) {
                temp[tempIndex] = arrayElement;
                tempIndex++;
                numberOfPrimes++;
            }
        }
        if (numberOfPrimes > 0) {
            int[] result = new int[numberOfPrimes];

            for (int i = 0; i < result.length; i++) {
                result[i] = temp[i];
            }
            return result;
        } else {
            String message = primeOrFibonacci ? "No such prime numbers in array." :
                    "No such fibonacci numbers in array.";
            throw new ProjectException(message);
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
        boolean result = false;
        int fibonacciNumber = 0;

        for (int i = 0; i < MAX_FIBONACCI_INDEX || fibonacciNumber > number; i++) {
            if (number == fibonacciNumber) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int calculateFibonacci(int index) {
        return (int) ((Math.pow((1 + Math.sqrt(5))/2, index) -
                Math.pow((1 - Math.sqrt(5))/2, index))/Math.sqrt(5));
    }
}
