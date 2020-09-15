package com.collections.map;

public class MyHashMap<K, V> implements MyMap<K, V> {

    private int initialCapacity;
    private float loadFactor;
    private final static int DEFAULT_INITIAL_CAPACITY = 16;
    private final static float DEFAULT_LOAD_FACTOR = 0.75f;
    private Entry<K,V> entries[];
    private int size;

    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity){
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor){
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initial capacity " + initialCapacity);
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Illegal initial load factor " + loadFactor);
        }
        this.initialCapacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.entries = new Entry[initialCapacity];
    }

    private int getStorageIndex(K key){
        return key.hashCode()%initialCapacity;
    }

    @Override
    public V put(K key, V value) {
        // handling of resizing of hashmap once num of entries reach load_factor * initialCapacity

        // handling of null key to be done

        // calculate bucket id for incoming key
        int storageIndex = getStorageIndex(key);
        Entry<K,V> initialEntry = entries[storageIndex];
        if(initialEntry == null){
            Entry<K, V> entry = new Entry<>(key,value);
            entries[storageIndex] = entry;
            size++;
        }else{
            // check if it is a new entry
            Entry<K, V> lastEntry = initialEntry;
            while (initialEntry != null){
                if(initialEntry.key.equals(key)){
                    V oldValue = initialEntry.value;
                    initialEntry.setValue(value);
                    return oldValue;
                }
                lastEntry = initialEntry;
                initialEntry = initialEntry.next;
            }
            Entry<K, V> entry = new Entry<>(key, value);
            lastEntry.next = entry;
            size++;
        }
        return null;
    }

    @Override
    public V get(K key) {
        int storageIndex = getStorageIndex(key);
        Entry<K,V> initialEntry = entries[storageIndex];
        while (initialEntry != null){
            if(initialEntry.key.equals(key)){
                return initialEntry.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public static class Entry<K,V>{
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
