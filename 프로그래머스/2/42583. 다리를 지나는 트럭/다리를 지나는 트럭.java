// 핵심 아이디어 : 큐 + dummy 데이터
// 처음에 큐에 다리의 길이만큼 더미데이터를 넣어준다.
// 견딜수 있는 무게만큼 트럭을 넣어준다.(다리 하중 무게 -= 트럭 무게) 견딜 수 없으면 더미데이터를 넣음
// 큐에서 하나씩 빼면서, 더미데이터가 아닌 트럭이 나오면 하중 무게를 다시 추가해준다.
// 큐에서 뺀 횟수를 리턴한다.
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++){
            bridge.add(-1); // -1은 더미데이터
        }
        
        int idx = 0;
        while(idx < truck_weights.length){
            // System.out.println(bridge);
            
            Integer passed = bridge.poll();
            
            //꺼낸 값이 트럭인지 더미데이터인지 확인
            if(passed != -1){
                weight += passed;
            }
            answer++;
            //다리에 올라갈 수 있으면
            if(weight >= truck_weights[idx]){
                bridge.add(truck_weights[idx]);
                weight -= truck_weights[idx];
                idx++;
            }//다리에 올라갈 수 없으면
            else{
                bridge.add(-1); // 더미데이터 추가
            }
            
            
        }
        
        // System.out.println(bridge);
        return answer+bridge.size();
    }
}