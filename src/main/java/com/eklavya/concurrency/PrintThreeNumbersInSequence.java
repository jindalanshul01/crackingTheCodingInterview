package com.eklavya.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintThreeNumbersInSequence {
    public static AtomicInteger nextThreadId = new AtomicInteger(1);
    public static AtomicInteger counter = new AtomicInteger(1);
    public static Object lock = new Object();
    public static int limit = 10;

    public static void main(String[] args) {
        NumberPrinterRunnable runnable1 = new NumberPrinterRunnable(1);
        NumberPrinterRunnable runnable2 = new NumberPrinterRunnable(2);
        NumberPrinterRunnable runnable3 = new NumberPrinterRunnable(3);

        Thread thread1 = new Thread(runnable1, "Thread 1");
        Thread thread2 = new Thread(runnable2, "Thread 2");
        Thread thread3 = new Thread(runnable3, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class NumberPrinterRunnable implements Runnable{
        int currThreadId;

        public NumberPrinterRunnable(int currThreadId) {
            this.currThreadId = currThreadId;
        }

        @Override
        public void run() {
            while (counter.get() <= limit){
                synchronized (lock) {
                    if (currThreadId != nextThreadId.get()){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(Thread.currentThread().getName() + " : " + counter);
                        counter.getAndIncrement();
                    }

                    if (currThreadId == 1){
                        nextThreadId.set(2);
                    } else if (currThreadId == 2){
                        nextThreadId.set(3);
                    }else if (currThreadId == 3){
                        nextThreadId.set(1);
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}