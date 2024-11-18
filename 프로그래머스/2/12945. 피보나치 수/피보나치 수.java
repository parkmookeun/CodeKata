class Solution {
    public long solution(int n) {
        long answer = 0;
        long value1 = 0;
        long value2 = 1;
        long temp = 0;
        
        for(int i=2; i<=n; i++){
            answer = value1 +value2;
            temp = value2;
            value2 = (value1 + value2) % 1234567;
            value1= temp % 1234567;
        }
        
        return answer % 1234567;
    }
}