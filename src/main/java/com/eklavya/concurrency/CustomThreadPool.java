package com.eklavya.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool{
    BlockingQueue<Runnable> queue;
    int queueSize;
    int nThreads;

    public CustomThreadPool(int queueSize, int nThreads) throws Exception {
        this.queueSize = queueSize;
        this.nThreads = nThreads;
        //queue = new CustomBlockingQueue<Runnable>(queueSize);
        queue = new ArrayBlockingQueue<>(queueSize);

        RunnableTask task = null;

        for(int i=1; i<=nThreads; i++){
            task = new RunnableTask(queue);
            new Thread(task, "Thread-"+i).start();
        }
    }

    public void submitTask(Runnable tasks) throws InterruptedException {
        //queue.enqueue(tasks);
        queue.offer(tasks);
    }
}

class RunnableTask implements Runnable{

    //CustomBlockingQueue<Runnable> queue;
    BlockingQueue<Runnable> queue;

    //public RunnableTask(CustomBlockingQueue<Runnable> queue){
    public RunnableTask(BlockingQueue<Runnable> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            String threadName = Thread.currentThread().getName();
            //Runnable task = (Runnable) queue.dequeue();
            Runnable task = null;
            try {
                task = (Runnable) queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Starting with execution of ["+threadName+"]");
            task.run();
            System.out.println("Completed execution of ["+threadName+"]");
        }
    }
}