package com.eklavya.designPatterns.singleton;

public class SingletonTester {

    public static void main(String[] args) {
        EnumSingleton obj1 = EnumSingleton.INSTANCE;
        EnumSingleton obj2 = EnumSingleton.INSTANCE;

        if (obj1 == obj2)
            System.out.println("Same objects!");
        else
            System.out.println("Different Objects!");
    }
}
