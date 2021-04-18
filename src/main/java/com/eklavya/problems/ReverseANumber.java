package com.eklavya.problems;

public class ReverseANumber {

    public static int reverseNumber (int input) {
        if (Integer.MAX_VALUE < input || Integer.MIN_VALUE > input) {
            return 0;
        }

        int reverse = 0;
        int remainder;
        while (input != 0) {
            remainder = input % 10;
            input = input / 10;

            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }
            reverse = reverse * 10 + remainder;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int output = reverseNumber(123);
        System.out.println(output);
    }
}