 import java.util.*;

class Solution {
    public int solution(String s) {
        // Map<String,Integer> map = new HashMap<>();
        int answer = 0;
        
        String[] stringArr = s.split("");
        System.out.println(Arrays.toString(stringArr));
        
        int targetCount = 0;
        int elseCount = 0;
        
        String x = stringArr[0];
        // map.put(x,1);
        
        for(int i=0; i<stringArr.length; i++){
            if(stringArr[i].equals(x)){
                targetCount++;
            }else{
                elseCount++;
            }
            //개수 비교
            if(targetCount == elseCount){
                answer += 1;
                targetCount = 0;
                elseCount = 0;
                
                System.out.println(x+targetCount);
                if(i+1 >= stringArr.length){
                    break;
                }
                x = stringArr[i+1];
            }
            
            if(i == stringArr.length-1){
                answer += 1;
            }
        }
        return answer;
    }
}