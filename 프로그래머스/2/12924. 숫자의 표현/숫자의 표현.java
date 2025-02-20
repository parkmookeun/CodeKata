//투포인터 문제
//시작점과 끝점을 잡고, 숫자를 계속 더해준다.
//n보다 크면 시작점 + 1, n보다 작으면 끝점 + 1

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n == 1){
            return 1;
        }
        
        int start = 1;
        int end = 2;
        
        int temp = start + end;
        
        
        while(start <= end){
            
            if(temp < n){
                
                end += 1;
                temp += end;
                
            }else if(temp > n){
                
                temp -= start;
                start += 1;
                
            }else{
                // temp == n 이면
                answer += 1;
                temp -= start;
                start += 1;
            }
        }
        
        return answer;
    }
}