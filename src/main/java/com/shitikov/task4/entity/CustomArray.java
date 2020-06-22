package com.shitikov.task4.entity;

import com.shitikov.task4.exception.ProjectException;

public class CustomArray {
    private final static int DEFAULT_CAPACITY = 10;

    private int[] array;

    public CustomArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public CustomArray(int[] array) {
        this.array = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public CustomArray(int length) {
        this.array = new int[length];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int elementByIndex(int index) throws ProjectException {
        if (index >= array.length) {
            throw new ProjectException("index is outside the array");
        }
        return array[index];
    }

    public int length() {
        return array.length;
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
                return  false;
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
                sb.append(array[i]).append("]");
                break;
            }
            sb.append(array[i]).append(",");
        }
        sb.append('}');
        return sb.toString();
    }
}
