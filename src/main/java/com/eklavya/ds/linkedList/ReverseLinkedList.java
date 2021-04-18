package com.eklavya.ds.linkedList;

import com.eklavya.ds.utils.Node;

public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head){
        Node previous = null;
        Node next = null;
        Node current = head;

        while (null != current){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
            next = current.getNext();
        }
        return head;
    }
}
