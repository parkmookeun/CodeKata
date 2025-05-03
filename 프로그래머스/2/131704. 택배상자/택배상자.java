import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        
        //컨테이너 벨트에 1 - n 까지 초기화
        for(int i=0; i<order.length; i++){
            queue.add(i+1);
        }
        
        for(int i=0; i<order.length; i++){
            //orders[i]를 꺼내기 위해 그 앞 택배를 스택에 넣기
            while(!queue.isEmpty() && queue.peek() <= order[i]){
                stack.add(queue.poll());
            }
            
            Integer poped = stack.pop();
            
            if(poped == order[i]) answer+=1;
            else break;   
            
        }
        
        return answer;
    }
}