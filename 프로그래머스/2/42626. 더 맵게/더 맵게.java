// 핵심 아이디어 : 우선순위 큐를 아는지
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(pq.size() >= 2 && pq.peek() < K){
            int n1 = pq.poll();
            int n2 = pq.poll();
            
            pq.add(n1+n2*2);
            answer++;
        }
        
        if(pq.size() == 1 && pq.peek() < K){
            answer = -1;
        }
        
        return answer;
    }
}