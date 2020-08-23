package Q200_Q249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) { // N，这题也没有什么难的，就是获得一个结果，同样要检查环的情况
        // can use an array or map to represent graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int[] item = prerequisites[i];
            map.get(item[0]).add(item[1]);
        }
        List<Integer> res = new ArrayList<>();
        int[] visitStatus = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(!dfs(map, i, visitStatus, res))
                return new int[0];
        }
        int[] arrRes = new int[numCourses];
        int idx = 0;
        for(Integer i : res) {
            arrRes[idx] = i;
            idx++;
        }
        return arrRes;
    }

    boolean dfs(Map<Integer, List<Integer>> depMap, int courseNum, int[] visitStatus, List<Integer> res) {
        if(visitStatus[courseNum]==2)  // visited
            return true;
        if(visitStatus[courseNum]==1)  // visiting, circle
            //throw new RuntimeException("circular dependency");
            return false;
        visitStatus[courseNum] = 1;
        for(Integer dep : depMap.get(courseNum)) {
            if(!dfs(depMap, dep, visitStatus, res))
                return false;
        }
        visitStatus[courseNum] = 2;
        res.add(courseNum);
        return true;
    }

    public static void main(String[] args) {
        int[][] deps = new int[][] {{1,0}};
        System.out.println(new Q210().findOrder(2, deps));
    }
}
