import java.util.Arrays;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        //각 자리 수가 몇개 있는지 체크
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        //각각의 배열 체크
        for(int i=0; i<X.length(); i++){
            xCount[Character.getNumericValue(X.charAt(i))] += 1;
        }
        
        for(int i=0; i<Y.length(); i++){
            yCount[Character.getNumericValue(Y.charAt(i))] += 1;
        }
        //높은 수부터 검사
        for(int i=9; i>=0; i--){
            int minCount = xCount[i] > yCount[i] ? yCount[i] : xCount[i];
            if(minCount == 0) continue;
            answer += String.valueOf(i).repeat(minCount);
        }
        
        if(answer.equals("")){
            answer = "-1";
        }
        
        if(answer.length() > 1 && answer.charAt(0) == '0'){
            answer = "0";
        }
        
        return answer;
    }
}