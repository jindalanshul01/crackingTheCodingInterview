package com.eklavya.ds.stack;

/*
* Problem Statement:
* -------------------
*
* Given a String which may consist of parentheses -> (,{,[,),},]
* identify if the parentheses are balanced. E.g.
* String s1 = "abc(qw{hg})" ------> is balanced
* String s2 = "xyz[pqr{}(zab)" ---> is NOT balanced
*
*/

import com.eklavya.ds.utils.CommonUtils;
import com.eklavya.ds.utils.TestInputsUtils;

import java.util.List;
import java.util.Stack;

public class BalancedParenthesesChecker {

    /*
    * Solution
    * -----------
    * Maintain an auxiliary data structure in a stack.
    * Every time an open bracket is encountered, push it into the stack.
    * Every time a closed bracket is encountered, check if the stack top has
    * corresponding open bracket. If yes, then proceed otherwise return false.
    *
    * Time Complexity: O(n)
    *       We need just one pass of the string to be able to identify
    *       if the parentheses are balanced or not. Hence linear.
    * Space Complexity: O(n)
    *       We are maintaining an auxiliary space (stack) to hold open brackets
    */

    public static boolean areParenthesesBalanced(String input){

        //Return true for a null string.
        if (null == input || input.isEmpty()){
            return true;
        }

        Stack<Character> parenthesesStack = new Stack<>();
        boolean result = false;
        char currentChar;

        for(int i=0; i<input.length(); i++){
            currentChar = input.charAt(i);
            /*
            * If current character is an open bracket, push it into the stack.
            * Else If current character is a closed bracket, check if the character
            * at top of the stack and the current character are a pair. If yes, then
            * proceed further, else break the sequence and return.
            */

            if (currentChar == '(' || currentChar == '{' || currentChar == '['){
                parenthesesStack.push(currentChar);
            }else if (currentChar == ')' || currentChar == '}' || currentChar == ']'){
                //If stack is empty and we found a closing bracket, then return false.
                if (parenthesesStack.isEmpty()){
                    result = false;
                    return result;
                }
                if (! isMatchingPair (parenthesesStack.pop(), currentChar)){
                    result = false;
                    break;
                }
            }
        }

        /*
        * If the stack is empty after checking for the entire string, return true.
        */
        if (parenthesesStack.isEmpty()){
            result = true;
        }

        return result;
    }

    /*
    * This methods checks if passed two brackets form a pair or not.
    * If yes, it returns true else false
    * Caveat: Checks only for '(', '{', '['
    */
    public static boolean isMatchingPair(char c1, char c2){
        boolean result = false;

        if (c1 == '(' && c2 == ')') {
            result = true;
        }else if (c1 == '{' && c2 == '}') {
            result = true;
        }else if (c1 == '[' && c2 == ']') {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        //Get test input Strings which cover as much scenarios as possible.
        List<String> testInputs = TestInputsUtils.getTestStringList();
        int counter = 1;
        Boolean output = false;

        CommonUtils.printTestSuiteStart();
        for (String input : testInputs){
            output = areParenthesesBalanced(input);
            CommonUtils.printFormattedOutputResults(input, output.toString(output), counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}