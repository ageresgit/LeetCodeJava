package com.github.ageresgit.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraphIterational {
    Node copyNode(Node oldNode, Map<Integer, Node> nodes) {
        Node newNode = new Node(oldNode.val);
        nodes.put(newNode.val, newNode);
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> nodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        copyNode(node, nodes);
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node oldNode = queue.poll();
            Node newNode = nodes.get(oldNode.val);
            for (Node next : oldNode.neighbors) {
                Node newNext = nodes.get(next.val);
                if (newNext == null) {
                    newNext = copyNode(next, nodes);
                    queue.offer(next);
                }
                newNode.neighbors.add(newNext);
            }
        }
        return nodes.get(1);
    }
}
