package com.eklavya.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    Callable<String> firstNameCallable = () -> {
        Thread.sleep(2000);
        return "Anshul ";
    };
    Callable<String> lastNameCallable = () -> {
        Thread.sleep(4000);
        return "Jindal ";
    };
    Callable<String> cityCallable = () -> {
        return "is From Dehradun";
    };

    public static void main(String[] args){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try{
            FutureExample obj = new FutureExample();
            List<Callable> callables = List.of(obj.lastNameCallable, obj.firstNameCallable, obj.cityCallable);
            List<Future<String>> futures = new ArrayList<>();

            Future<String> result;
            //Submit each callable.
            for (Callable callable : callables){
                result = (Future<String>) executorService.submit(callable);
                futures.add(result);
            }
            futures.forEach(FutureExample::accept);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //shut down the executor service now
            executorService.shutdown();
        }
    }

    private static void accept(Future<String> future){
        try{
            System.out.println(future.get());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}