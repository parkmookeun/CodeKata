//핵심 아이디어 : k개를 어떻게 뺄것인가? -> 앞에서부터 작은 수를 빼는 것이 좋다. (앞자리가 자리수가 더 크므로)
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        
        char[] numArr = number.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        int idx = 0;
        int count = 0;
        while(idx < numArr.length){
            
            while(!stack.isEmpty() && numArr[idx] > stack.peek() && count < k){
                stack.pop();
                count++;
            }
            
            stack.push(numArr[idx]);
            idx++;
        }
        
        while(count < k){
            count++;
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
            
        return sb.reverse().toString();
    }
}