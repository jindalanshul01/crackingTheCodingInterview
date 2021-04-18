package com.eklavya.problems;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<String> input = new ArrayList<>(10);
        int numberOfDays = in.nextInt();
        int numberOfIngredients = in.nextInt();
        for (int i = 0; i < numberOfDays; i++) {
            String ingredientId = in.next();
            input.add(ingredientId);
        }

        System.out.println(solution(input, numberOfIngredients));
    }

    public static String solution(List<String> ingredients, int numberOfIngredients){
        StringBuilder result = new StringBuilder();
        float fatCounter = 0;
        float fibreCounter = 0;
        float carbCounter = 0;
        int startPos = 0;
        int ingredientsCount = 0;
        for (int i=0; i<ingredients.size(); i++){
            if (ingredients.get(i).startsWith("FAT"))
                fatCounter++;
            else if (ingredients.get(i).startsWith("FIBER"))
                fibreCounter++;
            else if (ingredients.get(i).startsWith("CARB"))
                carbCounter++;
            ingredientsCount = i - startPos + 1;
            if ((ingredientsCount) >= numberOfIngredients &&
                    (fatCounter/(ingredientsCount) >= 0.6 || fibreCounter/(ingredientsCount) >= 0.6 || carbCounter/(ingredientsCount) >= 0.6)){
                for (int j=startPos; j<=i; j++){
                    result.append(ingredients.get(j));
                    if (i==j){
                        startPos = j+1;
                        fatCounter = fibreCounter = carbCounter = 0;
                        break;
                    }
                    result.append(":");
                }
            }else{
                result.append("-");
            }
        }
        return result.toString();
    }
}