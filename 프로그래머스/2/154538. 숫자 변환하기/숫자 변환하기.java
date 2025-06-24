import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[1000001];
        
        Arrays.fill(dp, 1000000);
        
        dp[y] = 0;
        for(int i = y; i > x; i--){
            if(i % 3 == 0){
                dp[i/3] = Math.min(dp[i] + 1, dp[i/3]);
            }
            if(i % 2 == 0){
                dp[i/2] = Math.min(dp[i] + 1, dp[i/2]);
            }
            if(i >= n){
                dp[i-n] = Math.min(dp[i] + 1, dp[i-n]);
            }
        }
        
        // for(int i=x; i<=y; i++){
        //     System.out.println(dp[i]);
        // }
        return (dp[x] == 1000000) ? -1 : dp[x];
    }
}