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