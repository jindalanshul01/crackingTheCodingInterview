package com.eklavya;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomProducerConsumer {
    Queue<Runnable> list = new LinkedList<>();
    int number = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition fullList = lock.newCondition();
    Condition emptyList = lock.newCondition();

    public Runnable producer() throws InterruptedException {
        Runnable taskToBeExecuted = null;

        while (true){
            taskToBeExecuted = () -> {
                number ++;
            };

            if (list.size() == 10){
                fullList.await();
            }

            while (list.size() <= 10){
                lock.lock();
                list.offer(taskToBeExecuted);
                emptyList.signalAll();
                lock.unlock();
            }

        }
    }

    public void consumer (Runnable taskToBeExecuted) throws InterruptedException {
        while (true){
            if (list.size() == 0){
                emptyList.await();
            }

            while (list.size() > 0){
                list.poll();
                fullList.signalAll();
            }
        }
    }

}
