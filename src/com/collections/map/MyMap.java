package com.collections.map;

public interface MyMap<K, V> {
    V put(K key, V value);
    V get(K key);
    int size();

}
