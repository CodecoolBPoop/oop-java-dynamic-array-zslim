package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {
    private int[] dataArray;
    public int length;
    public DynamicIntArray(int initialSize) {
        dataArray = new int[initialSize];
        this.length = initialSize;
    }
    public DynamicIntArray() {
        dataArray = new int[0];
        length = 0;
    }
    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            arrayString.append(" ");
            arrayString.append(dataArray[i]);
        }
        return arrayString.toString();
    }
    public int[] get() {
        return dataArray;
    }
    public void add(int number) {
        int[] newArray = new int[this.length + 1];
        System.arraycopy(dataArray, 0, newArray, 0, length);
        newArray[length] = number;
        dataArray = newArray;
        length++;
    }
    public void remove(int numberToDrop) {
        int[] newArray = new int[length];
        int nextNewArrayIndex = 0;
        int nextSectionStart = 0;
        for (int i = 0; i < length; i++) {
            if (dataArray[i] == numberToDrop) {
                System.arraycopy(dataArray, nextSectionStart, newArray, nextNewArrayIndex, i - nextSectionStart);
                nextNewArrayIndex += i - nextSectionStart;
                nextSectionStart = i + 1;
            }
        }
        System.arraycopy(dataArray, nextSectionStart, newArray, nextNewArrayIndex, length - nextSectionStart);
        nextNewArrayIndex += length - nextSectionStart;
        int[] result = Arrays.copyOfRange(newArray, 0, nextNewArrayIndex);
        if (nextSectionStart == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.dataArray = result;
        length = this.dataArray.length;
    }
    public void insert(int place, int number) {
        if (place < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] newArray = new int[length + 1];
        if (place >= length) {
            System.arraycopy(dataArray, 0, newArray, 0, length);
            newArray[newArray.length - 1] = number;
        } else {
            System.arraycopy(dataArray, 0, newArray, 0, place);
            newArray[place] = number;
            System.arraycopy(dataArray, place, newArray, place + 1, length - place);
        }
        dataArray = newArray;
        length = newArray.length;
    }
}
