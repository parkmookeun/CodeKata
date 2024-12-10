import java.util.*;
class Solution {
    public static int[] solution(int n, long left, long right) {

        List<Integer> list = new ArrayList<>();

        //left ~ right 까지
        int s_x = (int) (left / n);
        int s_y = (int) (left % n);
        int e_x = (int) (right / n);
        int e_y = (int) (right % n);
        while(true){
            if(s_y == n){
                s_y = s_y % n;
                s_x++;
            }

            list.add(Math.max(s_x+1,s_y+1));

            if(s_x == e_x && s_y == e_y) break;

            s_y++;
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}