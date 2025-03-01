// 핵심 아이디어 : 현재 탈락한 사람이 누구이고, 몇번째 차례인지를 인지 & 중복 허용 x인 자료구조에 단어 저장
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char endChar = words[0].charAt(words[0].length()-1);
        
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            
            // 같은 단어를 말한 경우
            if(wordSet.contains(words[i])){
                System.out.println(words[i]);
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            //끝말잇기가 제대로 안된 경우 
            if(endChar != words[i].charAt(0)){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            
            wordSet.add(words[i]);
            endChar = words[i].charAt(words[i].length()-1);
        }
        
        return answer;
    }
}