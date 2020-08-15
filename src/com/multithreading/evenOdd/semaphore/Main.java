package com.multithreading.evenOdd.semaphore;

public class Main {
    public static void main(String[] args) {
        SharedPrinter printer = new SharedPrinter();
        Thread evenThread = new Thread(new EvenRunnable(printer, 20), "EvenThread");
        Thread oddThread = new Thread(new OddRunnable(printer, 20), "OddThread");
        evenThread.start();
        oddThread.start();
    }
}
