// 핵심 아이디어 : 소비자가 구매를 원하는 모든 항목을 할인 가격으로 살수 있는 날에 회원가입
// 당사자의 구매 희망물품과 그 개수를 맵에 저장
// 1일부터 10일간의 할인물품과 그 갯수 맵에 저장
// discount의 요소를 1-10일까지 큐에 저장 -> 하루하루 지나면서, 앞 품목 제거 및 담날 품목 추가
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Deque;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String,Integer> toBuy = new HashMap<>();
        Map<String,Integer> toDiscount = new HashMap<>();
        
        Deque<String> disCount = new LinkedList<>();
        
        // 내 희망 목록과 그 갯수 맵에 저장
        for(int i=0; i<want.length; i++){
            toBuy.put(want[i],number[i]);        
        }
        
        // 1-10일까지의 할인 품목 목록과 그 갯수 맵에 저장
        for(int i=0; i<10; i++){
            toDiscount.put(discount[i], toDiscount.getOrDefault(discount[i],0) + 1);    
        }
        
        // 1-10일까지 할인 품목 목록 큐에 저장
        for(int i=0; i<10; i++){
            disCount.add(discount[i]);
        }
        
        
        // discount 배열 길이만큼 계속해서 회원가입 할 날짜 찾기
        int startIdx = 9;
        boolean isOk = false;
        
        while(startIdx <= discount.length-1){
            isOk = true;
            //모두 할인 가능한지 검사
            for(int i=0; i<want.length; i++){
                if(toBuy.get(want[i]) > toDiscount.getOrDefault(want[i],0)){
                    isOk = false;
                }    
            }
            
            if(isOk) answer++;

            startIdx++;
            
            if(startIdx == discount.length){
                break;
            }
            
            //큐에서 삭제하고 새값 추가
            String removed = disCount.pollFirst();
            disCount.add(discount[startIdx]);
            
            //큐에서 삭제한 값 및 새값 -> 맵에 반영
            toDiscount.put(removed, toDiscount.getOrDefault(removed,0) -1);
            toDiscount.put(discount[startIdx], toDiscount.getOrDefault(discount[startIdx],0)+1);
        }
        
        return answer;
    }
}