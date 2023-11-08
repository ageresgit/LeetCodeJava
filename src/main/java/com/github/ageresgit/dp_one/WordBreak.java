package com.github.ageresgit.dp_one;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    private boolean wordBreak(char[] chars, Trie trie, int start, boolean[] dp) {
        for (int i = start; i < chars.length; i++) {
            if (dp[i] && trie.getIsWord()) return true;
            trie = trie.getNext(chars[i]);
            if (trie == null) return false;
        }
        return trie.getIsWord();
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie head= new Trie(false);
        head.loadDictionary(wordDict);
        boolean[] dp = new boolean[s.length()];
        char[] chars = s.toCharArray();
        for (int i = dp.length - 1; i >= 0; i--) dp[i] = wordBreak(chars, head, i, dp);
        return dp[0];
    }
    public class Trie{
        private boolean isWord;
        private Map<Character, Trie> letters;
        Trie(boolean isWord) {
            this.isWord = isWord;
            this.letters = new HashMap<>();
        }
        public boolean getIsWord() {
            return isWord;
        }
        public void updateWord(boolean isWord) {
            if (isWord && !this.isWord) this.isWord = isWord;
        }
        public Trie addLetter(Character character, boolean isWord) {
            Trie trie = letters.get(character);
            if (trie == null) {
                trie = new Trie(isWord);
                letters.put(character, trie);
            }
            else trie.updateWord(isWord);
            return trie;
        }
        public void loadWord(String word) {
            if (word == null) return;
            Trie trie = this;
            for (char ch : word.toCharArray()) trie = trie.addLetter(ch, false);
            trie.updateWord(true);
        }
        public void loadDictionary(List<String> words) {
            for (var word : words) this.loadWord(word);
        }
        public Trie getNext(char ch) {
            return letters.get(ch);
        }
    }
}
