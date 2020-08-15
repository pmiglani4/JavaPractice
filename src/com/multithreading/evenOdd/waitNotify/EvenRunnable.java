package com.multithreading.evenOdd.waitNotify;

public class EvenRunnable implements Runnable{
    private Printer printer;
    private int max;
    public EvenRunnable(Printer printer, int max){
        this.printer = printer;
        this.max = max;
    }
    @Override
    public void run() {
        for (int i=2;i<=max;i=i+2){
            synchronized (printer){
                while (printer.printOdd){
                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.printNumber(i, Thread.currentThread().getName());
                printer.printOdd=true;
                printer.notify();
            }
        }
    }
}
