package Q001_Q049;

import java.util.Stack;

public class Q020 {
    public boolean isValid(String s) {  // n
        Stack<Character> stack = new Stack();
        String open = "({[";
        String close = ")}]";
        for(char c : s.toCharArray()) {
            String cStr = String.valueOf(c);
            if(!open.contains(cStr) && !close.contains(cStr))  // i just skipped non target chars
                continue;
            if(open.contains(cStr))
                stack.push(c);
            else {
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c==']' && top=='[' || c==')' && top=='(' || c=='}' && top=='{')  // note this logic must be correct, top is the open, c is close
                    continue;  // this condition is hard to skip by using "not"
                else
                    return false;
            }
        }
        if(stack.size()>0)
            return false;
        return true;
    }
}
