package com.eklavya.concurrency;

public class DefinitelyDeadlock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Runnable runnable1 = () -> {
          System.out.println("Trying to acquire obj1 from runnable1");
          synchronized (obj1){
              System.out.println("Acquired obj1 from runnable1");
              try{
                  System.out.println("Sleeping for 1s in runnable1");
                  Thread.sleep(1000);
              }catch (InterruptedException ex){
                  ex.printStackTrace();
              }
              System.out.println("Trying to acquire obj2 from runnable1");
              synchronized (obj2){
                  System.out.println("Acquired obj2 from runnable1");
              }
          }
        };

        Runnable runnable2 = () -> {
          System.out.println("Trying to acquire obj2 from runnable2");
          synchronized (obj2){
              System.out.println("Acquired obj2 from runnable2");
              System.out.println("Trying to acquire obj1 from runnable2");
              synchronized (obj1){
                  System.out.println("Acquired obj1 from runnable2");
              }
          }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
