package Q100_Q149;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {  // avgLen(w)*N*26; a little complex, but the method is straightforward, brute force only
        if(beginWord==null || endWord==null || wordList==null)
            return 0;
        Set<String> visited = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord))
            return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int steps = 1;   // as required by problem, default as 1
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String w = queue.poll();
                if(visited.contains(w))  // this step is important, otherwise it will take too much time for visited word
                    continue;
                visited.add(w);
                if(w.equals(endWord))
                    return steps;
                for(int j=0; j<w.length(); j++) {
                    for(char c='a'; c<='z'; c++) {  // memorize this iteration
                        String cand = w.substring(0, j) + c+w.substring(j+1);  // pay attention to the idx to use, it's j, not i; substring(0,j), substring(j+1), exclude char at j
                        if(dict.contains(cand) && !visited.contains(cand))
                            queue.offer(cand);
                    }
                }
            }
            steps++;
        }
        //return steps;  // here is the wrong statement, it should be 0 if it reaches the end, meaning no continuation to loop through
        return 0;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"hot","dot","dog","lot","log","cog"};
        System.out.println(new Q127().ladderLength("hit","cog",Arrays.asList(input)));
    }
}
