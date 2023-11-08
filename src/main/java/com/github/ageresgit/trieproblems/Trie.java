package com.github.ageresgit.trieproblems;

public class Trie {
    private class Vocabulary {
        TrieNode[] v;
        Vocabulary() {
            v = new TrieNode[26];
        }
        public void put(char c, TrieNode tn) {
            v[c - 'a'] = tn;
        }
        public TrieNode get(char c) {
            return v[c - 'a'];
        }
     }
    private class TrieNode {
        boolean isWord;
        int level;
        Vocabulary next;
        TrieNode(boolean isWord, int level) {
            this.isWord = isWord;
            this.level = level;
            this.next = new Vocabulary();
        }
    }
    private TrieNode root;
    private TrieNode getClosest(String target) {
        TrieNode closest = root;
        for (int index = 0; index < target.length(); index++) {
            TrieNode next = closest.next.get(target.charAt(index));
            if (next == null) return closest;
            closest = next;
        }
        return closest;
    }
    public Trie() {
        root = new TrieNode(false, 0);
    }
    public boolean startsWith(String prefix) {
        TrieNode closest = getClosest(prefix);
        return (closest.level == prefix.length());
    }
    public boolean search(String word) {
        TrieNode closest = getClosest(word);
        return (closest.level == word.length() && closest.isWord == true);
    }
    public void insert(String word) {
        TrieNode closest = getClosest(word);
        for (int index = closest.level; index < word.length(); index++) {
            TrieNode next = new TrieNode(false, index+1);
            closest.next.put(word.charAt(index), next);
            closest = next;
        }
        if (closest.isWord == false) closest.isWord = true;
    }
}
