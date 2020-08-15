package com.multithreading.evenOdd.waitNotify;

public class OddRunnable implements Runnable{

    private Printer printer;
    private int max;
    public OddRunnable(Printer printer, int max){
        this.printer = printer;
        this.max = max;
    }
    @Override
    public void run() {
        for (int i=1;i<=max;i=i+2){
            synchronized (printer){
                while (!printer.printOdd){
                    try {
                        printer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                printer.printNumber(i, Thread.currentThread().getName());
                printer.printOdd=false;
                printer.notify();
            }
        }
    }
}
