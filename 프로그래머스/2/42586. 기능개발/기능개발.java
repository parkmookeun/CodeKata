import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //큐에 progresses 값들을 넣는다.
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        int count = 0;
        int removedCount = 0;
        int idx = 0;

        //큐에 i번째 작업의 실행률을 넣는다.
        for(int i=0; i<progresses.length; i++){
            queue.add(progresses[i]);
        }
        //큐에 값이 없을 때까지
        while(!queue.isEmpty()){
            //큐의 사이즈 만큼 빼서 다시 넣기
            count = 0;
            idx = 0;
            while(!queue.isEmpty() && queue.peek() >= 100){
                queue.poll();
                count++;
                removedCount++;
            }

            if(count != 0){
                answerList.add(count);
            }

            //큐 업데이트 ( 다음 날로)
            while(idx != queue.size()){
                Integer polled = queue.poll();
                queue.add(polled+speeds[removedCount+idx]);
                idx++;
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}