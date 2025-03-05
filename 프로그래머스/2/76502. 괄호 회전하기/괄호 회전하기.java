//핵심 아이디어 : 괄호의 회전 표현방식(자료구조) + 올바른 괄호인지 검사 로직
// 큐 + 스택

import java.util.Deque;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int length = 0;
        int answer = 0;
        Deque<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        
        // s의 문자열을 전부 queue에 넣는다.
        for(int i=0; i<s.length(); i++){
            queue.add(s.charAt(i));
        }
        
        // queue의 문자열을 스택에 적용하여 올바른 괄호인지 검사한다.
        for(int i=0; i<queue.size(); i++){
            stack.clear();
            length = 0;
        
            while(length < s.length()){

                Character qChar = queue.pollFirst();

                if(stack.isEmpty() || map.get(stack.peek()) != qChar){
                    stack.push(qChar);
                }

                if(map.get(stack.peek()) == qChar){
                    stack.pop();
                }

                queue.add(qChar);
                length++;
            }
            if(stack.isEmpty()){
                answer++;
            }
            // 길이만큼의 검사가 끝나면, 첫번째 값을 빼서 마지막 갚에 넣어준다.
            queue.add(queue.pollFirst());
            }
            return answer;
    }
}