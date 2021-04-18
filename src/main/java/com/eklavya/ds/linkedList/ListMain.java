package com.eklavya.ds.linkedList;

import com.eklavya.ds.utils.LinkedListUtils;
import com.eklavya.ds.utils.Node;

public class ListMain {
    public static void main(String[] args) {
        Node head = LinkedListUtils.listWithAlphabeticalNodes(5);
        LinkedListUtils.printList(head);
        /*Node copy = LinkedListUtils.copyList(head);
        LinkedListUtils.printList(copy);*/
        /*char c =65;
        System.out.println(c);*/

    }
}