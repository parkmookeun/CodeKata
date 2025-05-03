import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        int idx = numbers.length-1;
        for(int i=numbers.length-1; i >= 0; i--){
            if(stack.isEmpty()){
                stack.push(numbers[i]);
                answer[idx] = -1;
                idx--;
                continue;
            }
            //
            while(!stack.isEmpty() && stack.peek() <= numbers[i]){
                stack.pop();
            }
            
            if(!stack.isEmpty()){
                answer[idx] = stack.peek();
                stack.push(numbers[i]);
                idx--;
            }else{
                stack.push(numbers[i]);
                answer[idx] = -1;
                idx--;
            }
        }
        return answer;
    }
}