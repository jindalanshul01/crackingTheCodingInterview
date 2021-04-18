package com.eklavya.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue <T> {
    Queue<T> queue;
    final int MAX_QUEUE_SIZE;
    ReentrantLock lock = new ReentrantLock();
    Condition fullCondition = lock.newCondition();
    Condition emptyCondition = lock.newCondition();

    public CustomBlockingQueue(int size) throws Exception {
        if (size <= 0){
            throw new Exception("Enter a number > 0");
        }
        this.MAX_QUEUE_SIZE = size;
        queue = new LinkedList();
    }

    public void enqueue (T task) throws InterruptedException {
        lock.lock();
        try{
            while (this.queue.size() >= MAX_QUEUE_SIZE){
                fullCondition.await();
            }
            queue.offer(task);
            emptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }


    public T dequeue () throws InterruptedException {
        T task;
        lock.lock();
        try{
            while (isEmpty()){
                emptyCondition.await();
            }
            task = queue.poll();
            fullCondition.signal();
            return task;
        }finally{
            lock.unlock();
        }
    }

    public boolean isEmpty(){
        return queue.size() == 0;
    }
}
