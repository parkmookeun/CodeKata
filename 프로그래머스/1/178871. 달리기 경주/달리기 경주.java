import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
    
        String[] answer = new String[players.length];
        
        
        Map<String,Integer> currSituation = new HashMap<>();
        
        //현재 상황 초기화
        for(int i=0; i<players.length; i++){
            currSituation.put(players[i],i);
            answer[i] = players[i];
        }
        
        //호출에 따라 순위 변경
        for(int i=0; i<callings.length; i++){
            //바꿀 idx 선언
            int idx = currSituation.get(callings[i]);
            //바꾸기
            String temp = answer[idx];
            answer[idx] = answer[idx-1];
            answer[idx-1] = temp;
            //맵에도 적용
            currSituation.put(answer[idx],idx);
            currSituation.put(answer[idx-1],idx-1);
            
        }
        return answer;
    }
}