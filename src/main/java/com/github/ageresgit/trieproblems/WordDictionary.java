package com.github.ageresgit.trieproblems;

public class WordDictionary {
    public class Vocabulary {
        TrieNode[] v;
        boolean isEmptyVocabulary;
        Vocabulary() {
            v = new TrieNode[26];
            isEmptyVocabulary = true;
        }
        public void put(char c, TrieNode tn) {
            v[c - 'a'] = tn;
            if (isEmptyVocabulary) isEmptyVocabulary = false;
        }
        public TrieNode get(char c) {
            return v[c - 'a'];
        }
        public boolean isEmpty() {
            return isEmptyVocabulary;
        }
    }
    public class TrieNode {
        boolean isWord;
        int level;
        Vocabulary next;
        TrieNode(boolean isWord, int level) {
            this.isWord = isWord;
            this.level = level;
            this.next = new Vocabulary();
        }
        boolean isEmpty() {
            return next.isEmpty();
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
    public WordDictionary() {
        root = new TrieNode(false, 0);
    }
    public boolean search(String word, TrieNode curr) {
        if (curr.level == word.length()) return curr.isWord;
        char ch = word.charAt(curr.level);
        boolean match = (!curr.isEmpty()) && (
                (ch == '.') || (curr.next.get(ch)  != null));
        if (ch != '.') return match && search(word, curr.next.get(ch));
        for (TrieNode tn: curr.next.v) {
            if (tn != null && search(word, tn)) return true;
        }
        return false;
    }
    public boolean search(String word) {
        return search(word, root);
    }
    public void addWord(String word) {
        TrieNode closest = getClosest(word);
        for (int index = closest.level; index < word.length(); index++) {
            TrieNode next = new TrieNode(false, index+1);
            closest.next.put(word.charAt(index), next);
            closest = next;
        }
        if (closest.isWord == false) closest.isWord = true;
    }
}
