package Q200_Q249;

public class Q243 {  // 这个题就是一个简单的贪心算法, N, 非常直接，但我开始没有想出来，要注意
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words==null)
            return -1;
        int idx1 = -1;
        int idx2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word1)) {
                idx1 = i;
                if(idx2!=-1) {
                    int len = Math.abs(idx1-idx2);
                    min = Math.min(min, len);
                }
            }
            if(words[i].equals(word2)) {
                idx2 = i;
                if(idx1!=-1) {
                    int len = Math.abs(idx1-idx2);
                    min = Math.min(min, len);
                }
            }
        }
        return min; // no need to check because it assumes both exists
    }
}
