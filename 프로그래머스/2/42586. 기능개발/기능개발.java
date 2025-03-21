// 핵심 아이디어 : 기능 별로 남은 일수 계산 + 스택 큐 활용
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        //남은 일수 큐에 저장
        for(int i=0; i<progresses.length; i++){
            int restDays = (int)(Math.ceil((double)(100 - progresses[i]) / speeds[i]));
            queue.add(restDays);
        }
        
        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int poll = queue.poll();
            int count = 1;
            //기능 하나 빼고 그 기능보다 빨리 완성되어있었으면 계속 빼기
            while(!queue.isEmpty() && queue.peek() <= poll){
                queue.poll();
                count++;
            }
            //정답 리스트에 개수 추가
            answer.add(count);
        }
        //정답 배열 리턴
        return answer.stream()
        .mapToInt(Integer::intValue)
            .toArray();
    }
}