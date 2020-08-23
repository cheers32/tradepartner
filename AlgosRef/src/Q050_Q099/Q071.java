package Q050_Q099;

import java.util.*;

public class Q071 {
    public String simplifyPath(String path) {  // this is a very similar approach as using a list; N
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for(String dir : path.split("/")) {
            if(dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if(!skip.contains(dir))
                stack.push(dir);
        }
        StringBuilder res = new StringBuilder();
        for(String dir : stack) {
            res.insert(0, dir);  // must append to front becuase it's a stack
            res.insert(0, "/");
        }
        return res.length()==0 ? "/" : res.toString();
    }
}
