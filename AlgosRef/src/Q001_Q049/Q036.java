package Q001_Q049;

import java.util.HashSet;
import java.util.Set;

public class Q036 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char v = board[i][j];
                if(v == '.')
                    continue;
                String rowKey = i+"r"+v;
                String columnKey = j+"c"+v;
                String boxKey = i/3+"_"+j/3+"b"+v;
                if(set.contains(rowKey) || set.contains(columnKey) || set.contains(boxKey))
                    return false;
                else {
                    set.add(rowKey);
                    set.add(columnKey);
                    set.add(boxKey);
                }
            }
        }
        return true;
    }
}
