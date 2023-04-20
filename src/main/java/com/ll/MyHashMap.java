package com.ll;

public class MyHashMap<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int arrLength) {
        this.keys = (K[]) new Object[arrLength];
        this.values = (V[]) new Object[arrLength];
    }

    public V put(K key, V value) {
        if(size + 1 > keys.length)
            increaseMapSize();
        keys[size] = key;
        values[size] = value;
        this.size++;

        return null;
    }

    public int size() {
        return this.size;
    }

    public V get(K key) {
        int index = findIndexOfKey(key);
        if(index != -1)
            return values[index];

        return null;
    }

    public void remove(K key_element) {

    }

    private void increaseMapSize() {
        K[] newKeyData = (K[]) new Object[this.size*2];
        V[] newValueData = (V[]) new Object[this.size*2];

        if(this.size > 0) {
            for(int i=0 ; i<this.size ;i++) {
                newKeyData[i] = keys[i];
                newValueData[i] = values[i];
            }
        }

        keys = newKeyData;
        values = newValueData;
    }

    private int findIndexOfKey(K key) {
        for(int i=0 ; i<size ; i++){
            if(keys[i].equals(key))
                return i;
        }

        return -1;
    }
}
