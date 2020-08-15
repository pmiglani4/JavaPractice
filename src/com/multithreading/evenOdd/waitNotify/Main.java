package com.multithreading.evenOdd.waitNotify;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printOdd=true;
        Thread evenThread = new Thread(new EvenRunnable(printer, 20), "EvenThread");
        Thread oddThread = new Thread(new OddRunnable(printer, 20), "OddThread");
        evenThread.start();
        oddThread.start();
    }
}
