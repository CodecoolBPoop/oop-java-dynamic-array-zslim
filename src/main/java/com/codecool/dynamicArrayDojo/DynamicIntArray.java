package com.codecool.dynamicArrayDojo;

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
        return "Implement me plz.. Pretty plz..";
    }
}
