// 스택을 사용해서 자신보다 작은 수가 들어오면 break 큰 수가 들어오면 second + 1
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // Stack<Integer> stack = new Stack<>();

        int second = 0;
        int idx = 0;
        
        while(idx < prices.length){
            
            second = 0;
            // stack.clear();
            
            for(int i=idx+1; i<prices.length; i++){
                // stack.push(prices[i]);
                second++;
                if(prices[idx] > prices[i]) break; 
            }
            
            // second = stack.size();
                
            answer[idx] = second;
            idx++;
        }
        
        return answer;
    }
}