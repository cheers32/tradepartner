package Q250_299;

public class Q261 {
    // 这道题就是检测graph里是否存在cycle, 有三种方法：dfs, topological sort, disjoint sets (union find)
    // 调任一新边，找到其两个顶点所在的set (findSet), 若不在一个set,则说明加入此edge无cycle, 可合并两个集合(union)
    // 每个set由一个节点代表
    // 用dfs是可以的，但是需要建立节点，比较麻烦, 这个题给的是边，所以正好用union find
    public boolean validTree(int n, int[][] edges) {  // N^2, because find need to use N time, and process for N edges
        if(edges == null)
            return false;
        if(edges.length != n-1)  // i changed this condition at the top, as a connected graph, must be exactly n-1 edges for n nodes
            return false;
        int[] sets = new int[n];  // corrected: this length should be n
        for(int i=0; i<n; i++) {
            sets[i] = i; // represent every node by it self
        }
        for(int[] e : edges) {
            int s1 = find(sets, e[0]);
            int s2 = find(sets, e[1]);
            if(s1==s2)
                return false;
            // union if no cycle so far
            sets[s2] = s1;  // update the set's id to another's, so that they become together
        }
        return true;
        //return edges.length == n-1;  // important: it requires this final condition, because it could be not a connected graph if less than n-1
    }

    int find(int[] sets, int nodeVal) {
        if(sets[nodeVal]==nodeVal)  // find the set id, this is the default situation
            return nodeVal;
        return find(sets, sets[nodeVal]);  // recursively find the parent set id
    }

    public static void main(String[] args) {
        //int[][] edges = new int[][] {{0,1},{0,2},{0,3},{1,4}};
        //System.out.println(new Q261().validTree(5, edges));
        int[][] edges = new int[][] {{0,1},{2,3}};
        System.out.println(new Q261().validTree(4, edges));
    }
}
