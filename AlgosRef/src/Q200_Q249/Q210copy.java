package Q200_Q249;

import java.util.LinkedList;
import java.util.Queue;

public class Q210copy {  // 这个ＢＦＳ的做法大概理解了，好像是逐步减少ｄｅｇｒｅｅ，然后进ｑｕｅｕｅ，同时进结果。
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;   // 开始先做一个 in degree的计数，表示该节点需要几个先驱节点

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  { // 访问每一个dependency, 若有人需要这个，则其计数减1
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }

    public static void main(String[] args) {
        int[][] deps = new int[][] {{1,0}};
        System.out.println(new Q210copy().findOrder(2, deps));
    }
}
