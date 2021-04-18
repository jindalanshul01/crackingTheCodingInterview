package com.eklavya.ds.strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/*Problem Statement
* Write an algorithm to identify is a passed string has all unique characters
* Validate the algorithm for negative/positive/edge test cases
*/
public class AllUniqueCharacters {
    private static final Logger log = LoggerFactory.getLogger(AllUniqueCharacters.class);
    private static final String EMPTY_STRING= "";
    private static final String LONG_STRING= "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private static final String NULL_STRING = null;
    private static final String ALL_WHITE_SPACES = "      ";
    private static final List<String> testStringList = Arrays.asList("abcdASjsd123","asjdfe234", "123456789", "12345678910", EMPTY_STRING, NULL_STRING, ALL_WHITE_SPACES, LONG_STRING);
    private static final List<String> testStringListLowerCases = Arrays.asList("abcdefjsd","abcdefghij", "123456789", "12345678910", EMPTY_STRING, NULL_STRING, ALL_WHITE_SPACES, LONG_STRING);

    public static void main(String args[]){
        for (String testString : testStringList){
            //hasUniqueChars_bruteForce(testString);
            //hasUniqueChars_withSet(testString);
            //hasUniqueChars_withBooleanArray(testString);
        }

        for (String testString: testStringListLowerCases){
            hasUniqueChars_stringWithLowerCaseCharsOnly(testString);
        }
    }

    /* This method employs brute force algorithm.
    *  Checks for each character against every other character and determines if any character is repeated or not.
    * Run Time Complexity: O(n^2)
    * Space Complexity O(1)
    */
    public static boolean hasUniqueChars_bruteForce(String input){

        //Checking for null and empty string
        if (Objects.isNull(input) || 0 == input.length()) {
            log.info("String [{}] is either null or empty.", input);
            return false;
        }

        for (int i=0; i<input.length(); i++){
            for (int j=i+1; j<input.length(); j++){
                if (input.charAt(i) == input.charAt(j)){
                    log.info("String [{}] has duplicates. Duplicate character is: [{}]", input, input.charAt(i));
                    return false;
                }
            }
        }
        log.info("String [{}] has all unique characters.", input);
        return true;
    }

    /*This method makes use of auxiliary Set<> data structure.
    * Set<> method add returns a boolean true or false as success status if the character was added to the Set<> or not.
    * In case a character has already been added to the Set<>, we immediately know if it is duplicate in the String.
    * Run Time Complexity: O(n)
    * Space Complexity O(n)
    */
    public static boolean hasUniqueChars_withSet(String input){

        //Checking for null and empty string
        if (Objects.isNull(input) || 0 == input.length()) {
            log.info("String [{}] is either null or empty.", input);
            return false;
        }

        Set<Character> characterSet = new HashSet<>(input.length());

        for (int i=0; i<input.length(); i++){
            if (Boolean.FALSE == characterSet.add(input.charAt(i))){
                log.info("String [{}] has duplicates. Duplicate character is: [{}]", input, input.charAt(i));
                return false;
            }
        }
        log.info("String [{}] has all unique characters.", input);
        return true;
    }

    /*Assumption: The String contains only ASCII values.
    * Maintain an auxiliary Boolean array of size 128. Initialize the array location to false.
    * Traverse through the entire string. For each character, check if the boolean flag is TRUE at the array location that corresponds to
    * character int value. If not, change flag in the boolean array to true at the index
    * Run Time Complexity: O(min(n,c)) or O(c). The for loop is not going to run more than 128 iterations. Hence, almost constant order.
    * Space Complexity: O(c) for c character string.
    */
    public static boolean hasUniqueChars_withBooleanArray(String input){

        //Checking for null and empty string
        if (Objects.isNull(input) || 0 == input.length()) {
            log.info("String [{}] is either null or empty.", input);
            return false;
        }

        /*If the string has a length of more than 128, then it obviously contains duplicates
        *  as there are only 128 distinct characters in ASCII.
        */
        if (input.length() > 128) {
            log.info("String [{}] has length > 128. It ought to have duplicates.", input);
            return false;
        }

        boolean[] boolChars = new boolean[128];
        for (int i=0; i<input.length(); i++){
            if (Boolean.TRUE == boolChars[input.charAt(i)]){
                log.info("String [{}] has duplicates. Duplicate character is: [{}]", input, input.charAt(i));
                return false;
            }else{
                boolChars[input.charAt(i)] = true;
            }
        }
        log.info("String [{}] has all unique characters.", input);
        return true;
    }

    /*Assumption: The String contains only lower case alphabets.
    * Maintain an integer variable to act as a 'checker'. Initialize the array location to false.
    * Traverse through the entire string. For each character, check if the bit of the 'checker' is 1.
    *       If yes, then its a duplicate char and return false.
    *       If no, then mark the bit to true and continue.
    * Run Time Complexity: O(n)
    * Space Complexity O(1)
    */
    public static boolean hasUniqueChars_stringWithLowerCaseCharsOnly(String input){

        //Checking for null and empty string
        if (Objects.isNull(input) || 0 == input.length()) {
            log.info("String [{}] is either null or empty.", input);
            return false;
        }

        /*If the string has a length of more than 128, then it obviously contains duplicates
        *  as there are only 128 distinct characters in ASCII.
        */
        if (input.length() > 26) {
            log.info("String [{}] has length > 128. It ought to have duplicates.", input);
            return false;
        }

        int checker = 0;
        int currChar = 0;
        for (int i=0; i<input.length(); i++){
            currChar = input.charAt(i) - 'a';
            if ((checker & (1<<currChar)) > 0){
                log.info("String [{}] has duplicates. Duplicate character is: [{}]", input, input.charAt(i));
                return false;
            }else{
                checker |= 1<<currChar;
            }
        }
        log.info("String [{}] has all unique characters.", input);
        return true;
    }
}