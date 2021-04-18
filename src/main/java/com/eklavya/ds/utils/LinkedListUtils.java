package com.eklavya.ds.utils;

import java.util.Random;

public class LinkedListUtils {

    public static void printList(Node head){
        Node currNode = head;
        if (currNode == null){
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();

        while (null != currNode){
            sb.append(currNode)
              .append("->");
            if (null == currNode.next){
                sb.append(" null");
                break;
            }
            currNode = currNode.next;
        }

        System.out.println(sb);
    }

    public static String listAsString(Node head){
        Node currNode = head;
        if (currNode == null){
            return "null";
        }
        StringBuilder sb = new StringBuilder();

        while (null != currNode){
            sb.append(currNode)
              .append("->");
            currNode = currNode.next;
        }
        sb.append(" null");
        return sb.toString();
    }

    public static Node randomListWithNodes(int n){
        //Can't create a list with less than 1 node.
        if (n < 1)
            return null;
        //Initialize a Random object.
        Random random = new Random(n);
        //Create a head node.
        Node head = new Node(random.nextInt(10),null);
        Node newNode = null;
        Node curr = head;
        for (int i=1;i<n;i++){
            newNode = new Node(random.nextInt(10),null);
            curr.next = newNode;
            curr = curr.next;
        }
        return head;
    }

    public static Node listWithAlphabeticalNodes(int n){
        //Can't create a list with less than 1 node.
        if (n < 1)
            return null;
        if (n > 26)
            throw new IllegalArgumentException("Provide a number between 1 and 26");
        char data = 65;
        Node newNode = null;
        Node curr = null;
        Node head = null;
        for (int i=1; i<=n; i++, data++){
            newNode = new Node(data, null);
            if (head == null){
                head = newNode;
                curr = newNode;
            }else{
                curr.next = newNode;
                curr = curr.next;
            }
        }
        return head;
    }

    public static Node copyList(Node head){
        if (null == head)
            return null;
        Node clone = new Node(head.getItem(), head.getNext());
        Node currMain = head.getNext();
        Node currClone = clone;
        Node newNode;
        while (null != currMain){
            newNode = new Node(currMain.getItem(), currMain.getNext());
            currClone.setNext(newNode);
            currClone = currClone.getNext();
            currMain = currMain.getNext();
        }
        return clone;
    }
}
