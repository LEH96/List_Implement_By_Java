package com.ll;

public class MyArrayList<T> {
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean add(T element) {
        this.size++;
        return true;
    }
}
