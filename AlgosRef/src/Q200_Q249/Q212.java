package Q200_Q249;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ds.ArrayUtil.printArray;

public class Q212 {  // 这个题是Trie+backtracking (make a change -> recursive -> undo change
    public List<String> findWords(char[][] board, String[] words) {  // time is m*n*len(word) for search, build is k*len(word)
        Q208.Trie trie = new Q208.Trie();
        for(String w : words) {  // build trie, time is k*avg(len(word))
            trie.insert(w);
        }
        Set<String> res = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, res, trie.root);  // this is a critical step by passing in the root node of newly built trie
            }
        }
        return new ArrayList<>(res);
    }

    void dfs(char[][] board, int i, int j, Set<String> res, Q208.TrieNode n) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) {
            return;
        }
        char c = board[i][j];
        if(c=='#')
            return;
        board[i][j] = '#';
//        if(n.isWord)    // another approach is to make n = n.children[c] at this step, and if check as null, then just revert and return; otherwise check word and recurse
//            res.add(n.word);
        if(n.children[c]!=null) {  // but i think my approach is clearer
            if(n.children[c].isWord)  // this is the only mistake i made, the current node doesn't have much info, check child node to verify final result
                res.add(n.children[c].word);
            dfs(board, i-1, j, res, n.children[c]);
            dfs(board, i, j+1, res, n.children[c]);
            dfs(board, i+1, j, res, n.children[c]);
            dfs(board, i, j-1, res, n.children[c]);
        }
        board[i][j] = c;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a'}};
        String[] words = new String[] {"a"};
        List<String> res = new Q212().findWords(board, words);
        System.out.println(res);
    }
}
