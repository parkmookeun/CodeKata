import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int count = 0;
        //1번기사부터 number기사까지
        for(int i=1; i<=number; i++){
            count = 0;
            for(int j=1; j<=(int)(Math.sqrt(i)); j++){
                if(j*j == i){
                    count += 1;
                    break;
                }
                if(i % j == 0){
                    count += 2;
                }
                
            }
            if(count > limit){
                answer += power;
            }else{
                answer += count;
            }
        }
        return answer;
    }
}