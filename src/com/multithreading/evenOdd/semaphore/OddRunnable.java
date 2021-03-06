package com.multithreading.evenOdd.semaphore;

import com.multithreading.evenOdd.waitNotify.Printer;

public class OddRunnable implements Runnable{

    private SharedPrinter printer;
    private int max;
    public OddRunnable(SharedPrinter printer, int max){
        this.printer = printer;
        this.max = max;
    }

    @Override
    public void run() {
        for (int i=1;i<=max;i=i+2){
            printer.printOdd(i);
        }
    }
}
