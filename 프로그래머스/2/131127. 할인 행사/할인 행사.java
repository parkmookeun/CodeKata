import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        //내가 원하는 품목의 종류와 개수를 담을 맵
        Map<String,Integer> wantedMap = new HashMap<>();
        //discount 배열에서 처음 10일간의 할인 품목의 종류와 개수를 담을 맵
        Map<String,Integer> discountMap = new HashMap<>();
        //discount 배열의 품목들을 계속해서 넣고 뺄 큐
        Queue<String> discountQue = new LinkedList<>();

        //원하는 품목 맵 초기화
        for(int i=0; i<want.length; i++){
            wantedMap.put(want[i],number[i]);
        }


        //처음 10일간 할인 품목 맵 초기화 및 큐 초기화
        for(int i=0; i<10; i++){
            Integer value = discountMap.get(discount[i]) == null ? 1 : discountMap.get(discount[i])+1;
            discountMap.put(discount[i],value);
            discountQue.add(discount[i]);
        }


        for(int i=10; i<=discount.length; i++){
            //비교
            answer += compareList(wantedMap,discountMap);
            if(i == discount.length){
                break;
            }
            //큐에서 넣고 빼기
            String removed = discountQue.remove();
            discountQue.add(discount[i]);
            //discount맵도 반영
            discountMap.put(removed,discountMap.get(removed)-1);
            Integer value = discountMap.get(discount[i]) == null ? 1 : discountMap.get(discount[i])+1;
            discountMap.put(discount[i],value);


        }
        return answer;
    }

    private int compareList(Map<String, Integer> wantedMap, Map<String, Integer> discountMap) {
        for (String s : wantedMap.keySet()) {
            if(wantedMap.get(s) > discountMap.getOrDefault(s,0)){
                return 0;
            }
        }
        return 1;
    }

}