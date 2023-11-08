package com.github.ageresgit.listproblems;

import java.util.HashMap;
import java.util.Map;

/*
A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.
Construct a deep copy of the list.
 */
public class DeepCopyWithRandomPointer {
    public Node copyRandomList(Node head){
        if (head == null) return null;
        // 1. Built copies into old list (copy goes right after its original)
        Node dummy = head;
        while (head != null) {
            Node copy = new Node(head.val);
            copy.next = head.next;
            head.next = copy;
            head = copy.next;
        }
        // 2. Assign values to the random pointers of copies: copy.random = original.random.next
        head = dummy;
        while (head != null) {
            Node copy = head.next;
            if (head.random != null) copy.random = head.random.next;
            head = copy.next;
        }
        // 3. Cut list with copies into 2 lists: oroginals and copies
        head = dummy;
        dummy = new Node(0);
        Node copy = dummy;
        while (head != null) {
            copy.next = head.next;
            head.next = copy.next.next;
            head = head.next;
            copy = copy.next;
        }
        return dummy.next;
    }
    //Solution with O(n) time complexity
    public Node copyRandomListOn(Node head) {
        if (head == null) return null;
        Map<Node, Node> nodes = new HashMap<>();
        Node dummy = new Node(0);
        Node prev = dummy;
        while (head != null) {
            Node curr = nodes.getOrDefault(head, new Node(head.val));
            nodes.put(head, curr);
            if (head.random != null) {
                curr.random = nodes.getOrDefault(head.random, new Node(head.random.val));
                nodes.put(head.random, curr.random);
            }
            prev.next = curr;
            head = head.next;
            prev = curr;
        }
        return dummy.next;
    }
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
