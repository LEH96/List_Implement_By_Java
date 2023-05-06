package com.ll;

public class MyHashMap<K, V> {
    private Entry[] entries;
    private int size = 0;

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int arrLength) {
        this.entries = new Entry[arrLength];
    }

    public V put(K key, V value) {
        int indexOfKey = findIndexOfKey(key);

        if (indexOfKey != -1) {
            V old = (V) entries[indexOfKey].value;
            entries[indexOfKey].value = value;
            return old;
        }

        if (size + 1 > entries.length)
            increaseMapSize();

        entries[size] = new Entry<>(key, value);
        this.size++;

        return null;
    }

    public int size() {
        return this.size;
    }

    public V get(K key) {
        int index = findIndexOfKey(key);
        if (index != -1)
            return (V) entries[index].value;

        return null;
    }

    public V remove(K key) {
        int indexOfKey = findIndexOfKey(key);

        if (indexOfKey == -1)
            return null;

        V removedKey = (V) entries[indexOfKey].value;
        entries[size - 1].value = null; //메모리 누수 방지
        entries = decreaseHashMap();
        this.size--;
        return removedKey;
    }

    public boolean containsKey(K key) {
        return findIndexOfKey(key) != -1;
    }

    public boolean containsValue(V value) {
        return findIndexOfValue(value) != -1;
    }

    public void clear() {
        this.size = 0;
        entries = new Entry[0];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private Entry[] decreaseHashMap() {
        Entry[] newEntries = new Entry[this.size - 1];

        int index = 0;
        for (Entry entry : entries) {
            if (entry.value != null)
                newEntries[index++] = entry;
        }

        return newEntries;
    }

    private void increaseMapSize() {
        Entry[] newEntries = new Entry[this.size * 2];

        if (this.size > 0) {
            for (int i = 0; i < this.size; i++) {
                newEntries[i] = entries[i];
            }
        }

        entries = newEntries;
    }

    private int findIndexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key))
                return i;
        }

        return -1;
    }

    private int findIndexOfValue(V value) {
        for (int i = 0; i < size; i++) {
            if (entries[i].value.equals(value))
                return i;
        }

        return -1;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
