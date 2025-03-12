//핵심 아이디어 : 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발되어도 배포는 함께 된다.

import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //배포가 된 작업들을 담을 배열
        List<Integer> answer = new ArrayList<>();
    
        //작업이 진행되었을 때, 100%인 작업의 개수와 인덱스
        int idx = 0;
        int count = 0;
        
        while(idx < progresses.length){
            count = 0;
            process(progresses, speeds);
            
            while( idx < progresses.length && progresses[idx] == 100){
                idx++;
                count++;
            }
            
            //한번 배포되었을 때 answer에 count를 추가
            if(count > 0){
                answer.add(count);    
            }
        }
        
        return answer.stream()
        .mapToInt(Integer::intValue)
            .toArray();
    }
    
    //진행 함수
    void process(int[] progresses, int[] speeds){
        for(int i=0; i<progresses.length; i++){
            progresses[i] = Math.min(progresses[i]+speeds[i],100);
        }
    }
}