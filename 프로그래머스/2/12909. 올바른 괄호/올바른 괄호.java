// 핵심 아이디어 :
// 닫느 괄호 수와 여는 괄호 수는 같아야 한다!
// 닫는 괄호가 여는 괄호보다 많으면 안된다!
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int open = 0;
        int close = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open += 1;
            }
            else{
                close += 1;
            }
            
            if(close > open){
                answer = false;
                break;
            }
        }
        //여는 괄호 수가 닫는 괄호 수와 같거나 큰 경우
        if(open > close){
            answer = false;
        }
        
        return answer;
    }
}