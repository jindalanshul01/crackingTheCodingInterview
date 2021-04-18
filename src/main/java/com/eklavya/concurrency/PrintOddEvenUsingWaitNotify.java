package com.eklavya.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintOddEvenUsingWaitNotify {
    AtomicInteger counter = new AtomicInteger(1);
    static int limit;

    public static void main(String[] args) {
        limit = 10;
        PrintOddEvenUsingWaitNotify object = new PrintOddEvenUsingWaitNotify();

        //Create odd and even threads
        Thread oddThread = new Thread(() -> object.printOdd(), "Odd Thread");
        Thread evenThread = new Thread(() -> object.printEven(), "Even Thread");

        //Start the threads
        evenThread.start();
        oddThread.start();
    }

    //This method contains logic to print odd numbers only.
    public void printOdd(){
        //Synchronize the logic
        synchronized (this){
            //Check if the counter hasn't reached the limit already.
            while (counter.get() < limit){
                //Check if the counter is even. If yes, wait for the even thread to print it
                while (counter.get() % 2 == 0){
                    try{
                        wait();
                    }catch (InterruptedException ex){
                         ex.printStackTrace();
                    }
                }
                //Counter is odd. Print it, increment the counter and notify the other thread.
                System.out.println(Thread.currentThread().getName() + " : "+ counter.get());
                counter.getAndIncrement();
                notify();
            }
        }
    }

    //This method contains logic to print even numbers only.
    public void printEven() {
        synchronized (this){
            while (counter.get() < limit){
                while (counter.get() % 2 != 0){
                    try{
                        wait();
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                //Counter is even. Print it, increment the counter and notify the other thread.
                System.out.println(Thread.currentThread().getName() + " : "+ counter);
                counter.getAndIncrement();
                notify();
            }
        }
    }
}