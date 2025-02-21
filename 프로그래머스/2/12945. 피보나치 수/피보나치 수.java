//피보나치 수는 f(n) = f(n-2) + f(n-1) 이다.
class Solution {
    public long solution(int n) {
        long answer = 0;
     
        long a = 0;
        long b = 1;
        
        while(n >= 2){
            answer = (a + b) % 1234567;
            a = b % 1234567;
            b = answer;
            n--;
        }
        
        return answer;
    }
}