package com.eklavya.designPatterns.singleton;

public final class MySingletonUsingDCL {

    public static volatile MySingletonUsingDCL INSTANCE;

    private MySingletonUsingDCL(){}

    public static MySingletonUsingDCL getInstance(){
        if (null == INSTANCE){
            synchronized (MySingletonUsingDCL.class){
                if (null == INSTANCE){
                    INSTANCE = new MySingletonUsingDCL();
                }
            }
        }
        return INSTANCE;
    }
}