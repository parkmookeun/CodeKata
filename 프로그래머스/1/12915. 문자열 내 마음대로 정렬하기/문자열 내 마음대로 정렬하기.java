import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 각 문자열의 인덱스 N번째 글자를 기준으로 오름차순
        // 각 문자열에 인덱스 N번째 글자를 앞에 더해준다.
        // 그리고 정렬를 한 후, 문자열을 인덱스 1부터 출력한다.
        
         String[] answer = new String[strings.length];
        
        ArrayList<String> words = new ArrayList<>();
        
        for(int i=0; i<strings.length; i++){
            
            words.add(strings[i].charAt(n)+strings[i]);
        }
        
        Collections.sort(words);
        
        for(int i=0; i<answer.length; i++){
            
            answer[i] = words.get(i).substring(1);
        }
        
        return answer;
    }
}