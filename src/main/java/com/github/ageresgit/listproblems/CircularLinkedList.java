package com.github.ageresgit.listproblems;

public class CircularLinkedList {
    private class Node{
        String data;
        Node next;
        Node first;
        Node(String s) {
            data = s;
        }
    }
    Node tail;
    int nodeCounter;
    CircularLinkedList() {
        nodeCounter = 0;
    }
    void add(String s) {
        if (tail == null) {
            tail = new Node(s);
            tail.first = tail;
        }
        else {
            Node node = new Node(s);
            tail.next = node;
            node.first = tail.first;
            tail.first = null;
            tail = node;
        }
        nodeCounter += 1;
    }
    boolean remove() {
        if (tail == null) return false;
        if (tail.first == tail) {
            tail.first = null;
            tail.next = null;
            tail = null;
        }
        else {
            Node first = tail.first;
            tail.first = first.next;
            first.next = null;
        }
        nodeCounter -= 1;
        return true;
    }
    boolean remove(String s) {
        if (tail == null) return false;
        if (nodeCounter == 1) {
            if (s.equals(tail.data)) {
                tail.first = null;
                tail = null;
                nodeCounter -= 1;
                return true;
            }
            else return false;
        }
        Node node = tail.first;
        if (s.equals(node.data)) {
            tail.first = node.next;
            node.next = null;
            nodeCounter -= 1;
            return true;
        }
        while (node.next != null) {
            if (s.equals(node.next.data)) break;
        }
        if (node.next == null) return false;
        if (node.next == tail) {
            node.first = tail.first;
            tail.first = null;
            node.next = null;
            tail = node;
        }
        else {
            node.next = node.next.next;
            node.next.next = null;
        }
        nodeCounter -= 1;
        return true;
    }
    int size() {
        return nodeCounter;
    }
    boolean isEmpty() {
        return (nodeCounter == 0);
    }
}
