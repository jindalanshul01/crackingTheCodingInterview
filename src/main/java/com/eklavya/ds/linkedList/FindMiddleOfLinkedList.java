package com.eklavya.ds.linkedList;

/*
 * Problem Statement:
 * -------------------
 *
 * Given a linked list, identify the Node in the middle
 * E.g.
 * Input  --> [7] -> [2] -> [4] -> [4] -> [6] -> null
 * Output --> [4]
 * Algorithm should be O(n) time complexity with single list traversal and
 * O(1) space complexity
 */

import com.eklavya.ds.utils.*;
import java.util.List;

public class FindMiddleOfLinkedList {

    /* Idea is to maintain two references - 'slow' and 'fast'
    * For every one 'slow' traversal further, 'fast' moves two steps ahead.
    * Hence, when 'fast' hits the end of the list, 'slow' will be exactly
    * half way behind it.
    * */
    public static Node getMiddleOfLinkedList(Node head){
        Node fast = head;
        Node slow = head;

        while (null != fast){
            fast = fast.getNext();
            //Hop 'fast' by 1 and check. If its null, then break.
            //Else hop 'fast' by 1 more and 'slow' by 1.
            if (null == fast){
                break;
            }else{
                fast = fast.getNext();
                slow = slow.getNext();
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        List<Node> testInputs = TestInputsUtils.getTestLists(); //Get test inputs which cover different scenarios
        Node inputCopy;
        Node output;
        int counter = 1;

        CommonUtils.printTestSuiteStart();
        for (Node input : testInputs){
            inputCopy = LinkedListUtils.copyList(input);  //Create copy of original list.
            output = getMiddleOfLinkedList(input); //Holds middle of the linked list
            CommonUtils.printFormattedOutputResults(null == inputCopy ? "null" : LinkedListUtils.listAsString(inputCopy),
                    null == output? "null" : output.toString(), counter);
            counter ++;
        }
        CommonUtils.printTestSuiteEnd();
    }
}
