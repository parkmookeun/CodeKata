class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int gcd = 0;
        
        if(n > m){
          gcd = returnGCD(n,m);    
        }else{
            gcd = returnGCD(m,n);
        }
        answer[0] = gcd;
        answer[1] = gcd * (n/gcd) * (m/gcd);
        
        return answer;
    }
    //유클리드 호제법
    int returnGCD(int n, int m){
        if(n % m == 0){
            return m;
        }
        return returnGCD(m, n % m);
    }
}