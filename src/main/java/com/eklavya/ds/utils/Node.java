package com.eklavya.ds.utils;

import java.util.*;

public class Node<E> {
    E item;
    Node<E> next;

    public Node(E element, Node<E> next) {
        this.item = element;
        this.next = next;
    }
    public Node(E element) {
        this.item = element;
        this.next = null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append(" [")
                 .append(item)
                 .append("] ")
                 .toString();
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}