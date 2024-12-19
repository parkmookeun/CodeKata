import java.util.*;
class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        //priorities의 인덱스, 큐 생성
        int p_idx = 0;
        Queue<Integer> queue = new LinkedList<>();

        //queue 초기화
        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
        }
        //priorities 배열 정렬
        Arrays.sort(priorities);
        for(int i = 0; i < priorities.length / 2; i++) {
            int temp = priorities[i];
            priorities[i] = priorities[priorities.length - 1 - i];
            priorities[priorities.length - 1 - i] = temp;
        }

        while(location >= 0){
            Integer polled = queue.poll();
            location--;

            if(polled == priorities[p_idx]){
                p_idx++;
                answer += 1;
            }else {
                queue.add(polled);
                if(location == -1){
                    location = queue.size()-1;
                }
            }
        }

        return answer;
    }
}