// Stack 을 이용한 쉬운 풀이가 가능!
import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack stack = new Stack<Character>();
        
        int idx = 0;
        while(idx < s.length()){
            
            if(stack.isEmpty()){
                stack.push(s.charAt(idx));
                idx++;
                continue;
            }    
            
            if(stack.peek().equals(s.charAt(idx))){
                stack.pop();
            }else{
                stack.push(s.charAt(idx));
            }
            
            idx++;
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        
        return answer;
    }
}