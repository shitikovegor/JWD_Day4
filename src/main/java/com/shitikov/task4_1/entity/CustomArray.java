package com.shitikov.task4_1.entity;

import com.shitikov.task4_1.exception.ProjectException;

import java.util.OptionalInt;

public class CustomArray {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY =10000;

    private int[] array;

    public CustomArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public CustomArray(int[] array) {
        if (array != null) {
            this.array = new int[array.length];

            for (int i = 0; i < array.length; i++) {
                this.array[i] = array[i];
            }
        } else {
            this.array = new int[DEFAULT_CAPACITY];
        }

    }

    public CustomArray(int length) {
        if (length > 0 && length <= MAX_CAPACITY) {
            this.array = new int[length];
        } else {
            this.array = new int[DEFAULT_CAPACITY];
        }
    }

    public boolean setElement(int index, int value) {
        boolean result = false;

        if (isIndexCorrect(index)) {
            array[index] = value;
            result = true;
        }
        return result;
    }

    public int getElement(int index) throws ProjectException {
        if (isIndexCorrect(index)) {
            return array[index];
        } else {
            throw new ProjectException("index is outside the array");
        }
    }

    public OptionalInt getElementOpt(int index) {
        return isIndexCorrect(index) ? OptionalInt.of(array[index]) : OptionalInt.empty();
    }

    public int length() {
        return array.length;
    }

    private boolean isIndexCorrect(int index) {
        boolean result = false;
        if (index >= 0 && index < array.length) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        CustomArray other = (CustomArray) obj;

        if (array.length != other.array.length)
            return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != other.array[i])
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        for (int element : array) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");

        if (array == null)
            return sb.append("null}").toString();

        sb.append("array=[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                sb.append(array[i]);
                break;
            }
            sb.append(array[i]).append(",");
        }
        sb.append("]}");
        return sb.toString();
    }
}
