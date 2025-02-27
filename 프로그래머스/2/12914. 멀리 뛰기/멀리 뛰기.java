// 다이나믹 프로그래밍
// dp(n) = dp(n-2) + dp(n-1)

class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        
        if(n <= 2){
            return n;
        }
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        return dp[n];
    }
}