package com.eklavya.ds.strings;

import com.eklavya.ds.utils.CommonUtils;
import com.eklavya.ds.utils.TestInputsUtils;
import java.util.List;

/*
 * Problem Statement:
 * -------------------
 *
 * Given a binary string comprising of only 0s and 1s, reduce and print the string
 * after removing all occurrences of '01' and '10' E.g.
 * Input  --> 0101001010
 * Output --> 00
 * Input  --> 0101101010
 * Output --> null
 * Input  --> 11110000
 * Output --> null
 *      Explanation: 11110000 -> 111000 -> 1100 -> 10 -> null
 */
public class PrintBinaryStringAfterRemoving01And10 {

    public static void main(String[] args) {
        List<String> testInputs = TestInputsUtils.getTestBinaryStringList(); //Get test inputs which cover different scenarios
        String output;
        int counter = 1;

        CommonUtils.printTestSuiteStart();
        for (String input : testInputs){
            output = remove01And10OccurrencesInString(input); //Reduced output return string
            CommonUtils.printFormattedOutputResults(input, output, counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }

    /* On careful observation it is evident that '01' and '10' can be removed
     * as long as we have equal count of 0s and 1s in the binary String. Its only
     * the extra 0s OR 1s that won't be reduced further and hence will have to be
     * returned.
     * Hence, we count the number of 0s and 1s in the String. Difference between
     * the two counts give us the length of the String and whichever count is more
     * among 0 and 1, gives us the reduced String character.
     *
     * Time Complexity: O(n)
     *       We need just one pass of the array to be able to identify '0' and '1' counts.
     *       Hence linear.
     * Space Complexity: O(1)
     *       We need only 2 variables to store counts of 0s and 1s.
     *       Hence constant.
     */
    public static String remove01And10OccurrencesInString (String str){

        //null and empty String check
        if (CommonUtils.isBlank(str)){
            return null;
        }

        StringBuilder finalString = new StringBuilder();
        int count0 = 0;
        int count1 = 0;
        Character c = null;
        int reducedStringCount = 0;

        //Traverse through the string and get counts of 0s and 1s.
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i) == '0'){
                count0 ++;
            }else{
                count1 ++;
            }
        }

        //Get reduced String count.
        reducedStringCount = str.length() - Math.min(count0, count1);

        //Based on greater count we know which number is going to be left out.
        //In case both counts match, then the reduced string is going to be null;
        if (count0 > count1){
            c = '0';
            reducedStringCount = count0 - count1;
        }else if (count1 > count0){
            c = '1';
            reducedStringCount = count1 - count0;
        }else{
            reducedStringCount = 0;
        }

        //Append the character as many times as the difference in count between 0s and 1s
        for (int i=0; i< reducedStringCount; i++){
            finalString.append(c);
        }

        return finalString.toString();
    }
}
