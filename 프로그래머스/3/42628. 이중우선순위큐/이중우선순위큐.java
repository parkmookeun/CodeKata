import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 핵심 아이디어 : 우선순위 큐 2개
 * 1. 우선순위 큐를 2개 만든다. (최댓값 기준과 최솟값 기준)
 * 2. I 숫자면 데이터 삽입
 * 3. D 숫자면 데이터 삭제 (2개 큐에서 모두삭제)
 **/
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> maxPQ =
                new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(String operation : operations) {
            String[] commands = operation.split(" ");
            if(commands[0].equals("I")) {
                //삽입 명령인 경우
                int value = Integer.parseInt(commands[1]);
                maxPQ.add(value);
                minPQ.add(value);
            }else{ //삭제 명령인 경우
                if(commands[1].equals("1")) {
                    Integer poll = maxPQ.poll();
                    minPQ.remove(poll);
                }else{
                    Integer poll = minPQ.poll();
                    maxPQ.remove(poll);
                }
            }
        }
        // 둘다 없으면 값이 없는 것 -> (0,0) 리턴
        if (maxPQ.isEmpty() && minPQ.isEmpty()) {
            return new int[]{0,0};
        }
        // 값이 있으면 각자에서 peek()값 리턴
        return new int[]{maxPQ.peek(), minPQ.peek()};
    }
}
