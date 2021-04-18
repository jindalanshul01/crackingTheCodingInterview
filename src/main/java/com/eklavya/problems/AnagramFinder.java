package com.eklavya.problems;

import java.util.Objects;


/*
 * Problem Statement:
 * -------------------
 *
 * Given two Strings, identify if they are anagrams or not.
 * Two Strings are said to be anagrams if their constituent alphabets are exactly same. E.g.
 * Strings "Debit Card" and "Bad Credit" are anagrams
 */

public class AnagramFinder {

    /*
    * Solution
    * ---------
    *
    * Approach to this solution is simple. If two Strings are to be anagrams, then they must be
    * constituted of the same characters. We could create a Map with key as each character and
    * value as the number of occurrence of the character in input string. Follow below steps:
    *   1. Traverse the first String, putting the character in Map if not available already
    *       in the Map with value as 1. If character is available, increment value by 1.
    *   2. Traverse second String, this time around decrementing the value by 1 each time
    *       a character is encountered.
    *   3. One final pass of the Map - if all the values are 0, its an anagram. Otherwise not.
    *
    * Time Complexity:
    *   One pass of each of two Strings in 2 * O(n) time ==> O(n), where n is chars in string
    *   One pass of Map in O(m) time where m are keys. m <= n
    *   Total: 2 O(n) + O(m) ~= O(n)
    *
    * Space Complexity:
    *   We need auxiliary DS, a Map, to hold chars and their occurrence count.
    *   Hence O(n)
    *
    * Optimization:
    *   If both the strings are guaranteed to be consisting of only alphabets and we are to
    *   check for them being anagram solely based on alphabets, then instead of a Map, we
    *   can leverage a char array instead of fixed 26 length with each array index representing
    *   a char. Index for a char is determined as char 'a' -> 0, 'b' -> 1, .... 'z' -> 25. The
    *   subsequent approach remains the same as explained above.
    *
    * Edge cases to consider:
    *   1) If any of the strings are null, they aren't anagram. null != null
    *   2) Remove all non alphabets from the string before embarking on the check
    *   3) Convert both the strings to lower case.
    *
    * e.g. "Debit // //// /// Card" and "bad      ---  cRedit" are anagrams.
    */

    public boolean isAnagram (String input1, String input2){
        String nonAlphabets = "[^a-zA-Z]";

        String str1 = input1.replaceAll(nonAlphabets, "");
        String str2 = input2.replaceAll(nonAlphabets,"");

        if (Objects.isNull(str1) || Objects.isNull(str2))
            return false;

        if (str1.length() != str2.length())
            return false;

        boolean isAnagram = Boolean.TRUE;

        //Initialize char array to store characters occurrence
        int[] charArray = new int[26];
        int index;

        //Convert both input strings to lower for sake of comparison
        String string1Lower = str1.toLowerCase();
        String string2Lower = str2.toLowerCase();

        //O(n)
        for (Character c : string1Lower.toCharArray()){
            index = c - 'a';
            charArray[index] = charArray[index] ++;
        }

        //O(n)
        for (Character c : string2Lower.toCharArray()){
            index = c - 'a';
            charArray[index] = charArray[index] --;
        }

        //O(k) where k<=26
        for (int i : charArray){
            if (charArray[i] != 0){
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }

    public static void main(String[] args) {
        AnagramFinder tester = new AnagramFinder();
        boolean result = tester.isAnagram("Debit // //// /// Card", "bad      ---  cRedit");
        System.out.println(result);
    }
}