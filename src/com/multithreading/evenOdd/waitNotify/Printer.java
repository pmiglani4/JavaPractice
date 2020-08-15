package com.multithreading.evenOdd.waitNotify;

public class Printer {
    public volatile boolean printOdd;

    public void printNumber(int i, String name) {
        System.out.println("Thread: "+name +": "+i);
    }
}
