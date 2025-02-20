// n에서 1씩 더하면서 검증 로직을 수행한다.

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = 0;
        int iterCount = 0;
        
        String num = Integer.toBinaryString(n);
        
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) == '1'){
                count++;
            }    
        }   
        
        n += 1;
        
        while(true){
            iterCount = 0;
            num = Integer.toBinaryString(n);
            
            for(int i=0; i<num.length(); i++){
            if(num.charAt(i) == '1'){
                iterCount++;
                }    
            }   
            
            if(iterCount == count){
                answer = n;
                break;
            }
            n+= 1;
        }
            
        return answer;
    }
}