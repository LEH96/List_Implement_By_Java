package com.ll;

import java.util.stream.IntStream;

public class MyArrayList<T> {
    private final boolean debug = false;
    private T[] data;
    private int size;

    public MyArrayList() {
        this(2);
    }
    public MyArrayList(int initialLength){
        data = (T[]) new Object[initialLength];
    }

    public int size() { return this.size; }
    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean add(T element) {
        if(size + 1 > data.length)
            increaseArrayList();
        data[this.size++] = element;
        this.size++;
        return true;
    }

    public boolean add(int index, T element){
        if(size + 1 > data.length)
            increaseArrayList();

        makeEmptyIndex(index);

        data[index] = element;
        this.size++;

        return true;
    }

    public T remove(int index) {
        if(index >= data.length || index < 0)
            throw new IndexOutOfBoundsException();

        T removedData = data[index];
        data[index] = null;
        data = decreaseArrayList();
        this.size--;
        return removedData;
    }

    public T get(int index) {
        if(0 <= index && index <= this.size)
            return data[index];

        throw new IndexOutOfBoundsException();
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public int indexOf(T element) {
        for(int i=0 ; i<this.size ; i++){
            if(data[i].equals(element))
                return i;
        }
        return -1;

//        return IntStream.range(0, size)
//                    .mapToObj(index -> new Object[]{index, data[index]})
//                    .filter(arr -> element.equals(arr[1]))
//                    .mapToInt(arr -> (int)arr[0])
//                    .findFirst()
//                    .orElse(-1);
    }

    public void clear() {
        this.size = 0;
        data = (T[]) new Object[0];
    }

    private void makeEmptyIndex(int index) {
        for(int i = size - 1; i >=index ; i--)
            data[i + 1] = data[i];
    }

    private void increaseArrayList() {
        T[] newdata = (T[]) new Object[this.size*2];
        if(debug){
            System.out.printf("배열 크기 : %d \n", newdata.length);
        }

        if(this.size > 0) {
            for(int i=0 ; i<this.size ;i++)
                newdata[i] = data[i];
        }

        data = newdata;
    }

    private T[] decreaseArrayList() {
        T[] newdata = (T[]) new Object[this.size-1];
        int index = 0;
        for(T element : data){
            if(element != null)
                newdata[index++] = element;
        }
        return newdata;
    }
}
