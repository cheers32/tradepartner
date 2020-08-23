package Q200_Q249;

import java.util.*;

public class Q207v2 {
    // N, 这个题其实就是判断是否有循环dependency, 可以优化用一个array, 但这个方法好像时间不够快
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // can use an array or map to represent graph
        Map<Integer, List<Integer>> map = new HashMap<>();  // 很多题是把这个做成了一个普通list，从而提高速度，我觉得那个适用性不够
        for(int i=0; i<numCourses; i++) {  // 这个预处理还是很有必要的
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int[] item = prerequisites[i];
            map.get(item[0]).add(item[1]);
        }
        for(int i=0; i<numCourses; i++) {
            int[] visitStatus = new int[numCourses];
            if(!dfs(map, i, visitStatus))
                return false;   // 这个题的关键就在于判断是否有环，所以需要一个visiting status
//            if(visited.size()==numCourses)
//                return true;
        }
        return true;
    }

    boolean dfs(Map<Integer, List<Integer>> depMap, int courseNum, int[] visitStatus) {
        if(visitStatus[courseNum]==2)
            return true;
        if(visitStatus[courseNum]==1)
            return false;
        visitStatus[courseNum] = 1;
        for(Integer dep : depMap.get(courseNum)) {
            if(!dfs(depMap, dep, visitStatus)) {
                return false;
            }
        }
        visitStatus[courseNum] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] deps = new int[][] {{1,0}};
        System.out.println(new Q207v2().canFinish(2, deps));
    }
}
