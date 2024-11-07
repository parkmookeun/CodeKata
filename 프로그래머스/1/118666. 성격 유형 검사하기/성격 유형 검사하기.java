import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        map.put('R',0);map.put('T',0);
        map.put('C',0);map.put('F',0);
        map.put('J',0);map.put('M',0);
        map.put('A',0);map.put('N',0);

        for(int i=0; i<survey.length; i++){
            if(choices[i] > 4){
                map.put(survey[i].charAt(1),map.get(survey[i].charAt(1)) + choices[i]-4);
            }else if(choices[i] < 4){
                map.put(survey[i].charAt(0),map.get(survey[i].charAt(0)) + 4- choices[i]);
            }
        }

        answer += map.get('R') >= map.get('T') ? 'R' : 'T';
        answer += map.get('C') >= map.get('F') ? 'C' : 'F';
        answer += map.get('J') >= map.get('M') ? 'J' : 'M';
        answer += map.get('A') >= map.get('N') ? 'A' : 'N';
        
        return answer;
    }
}