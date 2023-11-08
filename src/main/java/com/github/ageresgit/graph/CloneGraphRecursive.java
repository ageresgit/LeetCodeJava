package com.github.ageresgit.graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraphRecursive {
    Node cloneNode(Node node, Map<Integer, Node> nodes) {
        Node newNode = nodes.get(node.val);
        if (newNode != null) return newNode;
        newNode = new Node(node.val);
        nodes.put(newNode.val, newNode);
        for (Node next : node.neighbors) newNode.neighbors.add(cloneNode(next, nodes));
        return newNode;
    }
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> nodes = new HashMap<>();
        return cloneNode(node, nodes);
    }
}
