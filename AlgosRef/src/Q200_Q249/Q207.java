package Q200_Q249;

import java.util.*;

public class Q207 {
    // 这个题其实就是判断是否有循环dependency, 可以优化用一个array
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // can use an array or map to represent graph
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int[] item = prerequisites[i];
            map.get(item[0]).add(item[1]);
        }
        for(int i=0; i<numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            Set<Integer> visiting = new HashSet<>();
            if(!dfs(map, i, visited, visiting))
                return false;
//            if(visited.size()==numCourses)
//                return true;
        }
        return true;
    }

    boolean dfs(Map<Integer, List<Integer>> depMap, int courseNum, Set<Integer> visited, Set<Integer> visiting) {
        if(visited.contains(courseNum))
            return true;
        if(visiting.contains(courseNum))
            return false;
        visiting.add(courseNum);
        for(Integer dep : depMap.get(courseNum)) {
            if(!dfs(depMap, dep, visited, visiting)) {
                return false;
            }
        }
        visiting.remove(courseNum);
        visited.add(courseNum);
        return true;
    }

    public static void main(String[] args) {
        int[][] deps = new int[][] {{1,0}};
        System.out.println(new Q207().canFinish(2, deps));
    }
}
