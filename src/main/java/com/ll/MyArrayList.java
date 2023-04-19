package com.ll;

public class MyArrayList<T> {
    private T[] data = (T[]) new Object[0];
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean add(T element) {
        data = increaseListArr();
        data[this.size++] = element;
        return true;
    }

    public T remove(int index) {
        T removedData = data[index];
        data[index] = null;
        data = decreaseListArr();
        this.size--;
        return removedData;
    }

    public T get(int index) {
        if(0 <= index && index <= this.size)
            return data[index];

        return null;
    }

    public boolean contains(T element) {
        for(T e : data)
            if(e.equals(element))
                return true;

        return false;
    }

    public int indexOf(T element) {
        for(int i=0 ; i<this.size ; i++){
            if(data[i].equals(element))
                return i;
        }
        return -1;
    }

    public void clear() {
        this.size = 0;
        data = (T[]) new Object[0];
    }

    private T[] increaseListArr() {
        T[] newdata = (T[]) new Object[this.size+1];
        if(this.size > 0)
            for(int i=0 ; i<this.size ;i++){
                newdata[i] = data[i];
            }
        return newdata;
    }

    private T[] decreaseListArr() {
        T[] newdata = (T[]) new Object[this.size-1];
        int index = 0;
        for(T element : data){
            if(element != null)
                newdata[index++] = element;
        }
        return newdata;
    }
}
