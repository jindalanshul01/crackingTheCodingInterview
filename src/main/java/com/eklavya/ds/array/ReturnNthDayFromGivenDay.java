package com.eklavya.ds.array;

/*
 * Problem Statement:
 * -------------------
 *
 * Write a method which would return nth day from a given day. E.g.
 * Input1: "Tuesday", 4   --> Saturday
 * Input2: "Saturday", 12 --> Thursday
 */

import com.eklavya.ds.utils.CommonUtils;
import java.util.Arrays;
import java.util.List;

public class ReturnNthDayFromGivenDay {
    public static String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    /*
     * Solution
     * -----------
     * Maintain a global array containing all the 7 days.
     * The day repeats after every 7 days, and hence we calculate (nth day modulo 7).
     * This modulo result added to the current day will give us the resultant day.
     * Maintain a global array of days, to identify the index of given day and return
     * resultant day.
     *
     * Time Complexity: O(n)
     *       We need to traverse the global days array once to be able to identify the index of
     *       input day. This is achieved in O(n) time. Fetching resultant day is a constant time operation.
     *       Hence linear.
     * Space Complexity: O(1)
     *       No auxiliary data structure maintained.
     *       Hence constant time.
     */
   public static String returnNthDay (String day, Integer dayToReturn){
       String nthDay = null;
       final String ERROR1 = "Incorrect days to return passed.";
       final String ERROR2 = "Incorrect day passed.";
       //null check for
       if (null == dayToReturn || dayToReturn < 0){
           return ERROR1;
       }
       int inputDayIndex = indexOfDay(day);
       if (inputDayIndex == -1){
           return ERROR2;
       }

       dayToReturn = (inputDayIndex + dayToReturn) % 7;
       nthDay = daysOfWeek[dayToReturn];

       return nthDay;
   }

   public static int indexOfDay (String day){
       int indexOfDay = -1;
       if (null == day) return indexOfDay;
       for (int i=0; i<daysOfWeek.length; i++){
           if (daysOfWeek[i].equals(day)){
               indexOfDay = i;
               break;
           }
       }
       return indexOfDay;
   }

    public static void main(String[] args) {
        //Get test input int arrays which cover as much scenarios as possible.
        List<String> testInputDays = Arrays.asList(null, "Monday", "Tue", "Saturday", "Sunday", "Monday", "Thursday");
        List<Integer> testInputInt = Arrays.asList(1, -3, 4, 40, 14, 12, 112);
        int counter = 1;
        String output;
        String input;

        CommonUtils.printTestSuiteStart();
        for (int i=0; i<testInputDays.size(); i++){
            input = testInputDays.get(i) + ", " + testInputInt.get(i);
            output = returnNthDay(testInputDays.get(i), testInputInt.get(i));
            CommonUtils.printFormattedOutputResults(input, output, counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}
