package com.github.ageresgit.trieproblems;
public class WordSearchInASquare {
    private class Vocabulary {
        TrieNode[] data;
        Vocabulary() {data = new TrieNode[26];}
        public void put(char c, TrieNode tn) {data[c - 'a'] = tn;}
        public TrieNode get(char c) {return data[c - 'a'];}
    }
    private class TrieNode {
        private int level;
        private Vocabulary letters;
        TrieNode(int level) {
            this.level = level;
            this.letters = new Vocabulary();
        }
        public void put(char c, TrieNode tn) {letters.put(c, tn);}
        public TrieNode get(char c) {return letters.get(c);}
        public int getLevel() {return level;}
    }
    private TrieNode root;
    private TrieNode getClosest(String target) {
        TrieNode closest = root;
        for (int index = 0; index < target.length(); index++) {
            TrieNode next = closest.get(target.charAt(index));
            if (next == null) break;
            closest = next;
        }
        return closest;
    }
    private void addWords(char[][] b, TrieNode cur, int row, int col, int maxLen) {
        if (row < 0 || row >= b.length || col < 0 || col >= b[row].length || b[row][col] == 0) return;
        if (maxLen <= cur.getLevel()) return;
        char ch = b[row][col];
        b[row][col] = 0;
        TrieNode node = cur.get(ch);
        if (node == null) {
            node = new TrieNode(cur.getLevel() + 1);
            cur.put(ch, node);
        }
        addWords(b, node, row - 1, col, maxLen);
        addWords(b, node, row + 1, col, maxLen);
        addWords(b, node, row, col - 1, maxLen);
        addWords(b, node, row, col + 1, maxLen);
        b[row][col] = ch;
    }
    public WordSearchInASquare(char[][] board, int maxWordLength){
        root = new TrieNode(0);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                addWords(board, root, row, col, maxWordLength);
            }
        }
    }
    public boolean search(String prefix) {
        TrieNode closest = getClosest(prefix);
        return (closest.getLevel() == prefix.length());
    }
}
