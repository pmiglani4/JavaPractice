package com.multithreading.evenOdd.semaphore;

import java.util.concurrent.Semaphore;

public class SharedPrinter {
    private Semaphore semEven = new Semaphore(0);
    private  Semaphore semOdd = new Semaphore(1);

    void printEven(int num){
        try{
            semEven.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
        semOdd.release();
    }
    void printOdd(int num){
        try{
            semOdd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
        semEven.release();
    }
}
