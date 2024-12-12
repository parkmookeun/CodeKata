import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        //정답을 담을 배열
        int[] answer = new int[targets.length];
        
        //keymap을 전부 합쳐서 각 문자를 누르키위해 최소한의 누름만 저장된
        //효율적인 map
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            String key = keymap[i];
            for(int j=0; j<key.length(); j++){
                char target = key.charAt(j);
                if(map.get(target) == null){
                    map.put(target,j+1);
                }else{
                    if(map.get(target) > j+1) map.put(target,j+1);
                }
            }
        }
        
        //이제 키판에 맞춰서 targets들 검사
        for(int i=0; i<targets.length; i++){
            int subAnswer = 0;
            for(int j=0; j<targets[i].length(); j++){
                //만약에 키판에 문자가 없는 경우
                if(map.get(targets[i].charAt(j)) == null){
                    subAnswer = -1;
                    break;
                }
                //있는 경우
                subAnswer += map.get(targets[i].charAt(j));
            }
            answer[i] = subAnswer;
        }
        
        return answer;
    }
}