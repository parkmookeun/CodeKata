import java.util.*;

class Solution {
    public int solution(int n) {
        String num = Integer.toString(n,3);
        StringBuffer sb = new StringBuffer(num);
        num = sb.reverse().toString();
        return Integer.parseInt(num,3);
    }
}