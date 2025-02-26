//거꾸로 생각하기
//5에서 최대한 칸을 안쓰는 방향으로 생각해보기

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n > 0){
            if(n % 2 == 1){
                n -= 1;
                ans += 1;
            }
            n /= 2;
        }
        return ans;
    }
}