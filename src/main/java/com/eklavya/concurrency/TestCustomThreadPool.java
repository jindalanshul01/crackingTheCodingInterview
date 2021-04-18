package com.eklavya.concurrency;

public class TestCustomThreadPool {
    public static void main(String[] args) throws Exception {
        CustomThreadPool threadPool = new CustomThreadPool(3,7);
        for (int taskNumber=1; taskNumber<=7; taskNumber++){
            TestTask task = new TestTask(taskNumber);
            threadPool.submitTask(task);
        }
    }
}

class TestTask implements Runnable {
    private int taskNumber;

    public TestTask(int taskNumber){
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        System.out.println("Executing task - "+taskNumber);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed task - "+taskNumber);
    }
}