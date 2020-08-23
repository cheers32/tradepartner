package Q200_Q249;

public class Q208 {
    static class Trie {  // N, passed the first time, looks like my skill is improved!
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {  // 这里只需要两个field, 不需要存自身值
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode n = root;
            for(char c : word.toCharArray()) {
                if(n.children[c]==null) {
                    n.children[c] = new TrieNode();
                }
                n = n.children[c];
            }
            n.isWord = true;
            n.word = word;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode n = root;
            for(char c : word.toCharArray()) {
                if(n.children[c]==null)
                    return false;
                n = n.children[c];
            }
            if(n.isWord)
                return true;
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode n = root;
            for(char c : prefix.toCharArray()) {
                if(n.children[c]==null)
                    return false;
                n = n.children[c];
            }
            return true;
        }
    }

    static class TrieNode {
        boolean isWord;
        String word;
        TrieNode[] children = new TrieNode[128];  // could also be a map, with char to node; this can also be used as c-'a' 26 letter array
    }
}
