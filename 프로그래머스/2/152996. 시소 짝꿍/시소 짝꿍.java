import java.util.*;

class Solution {
    long answer = 0;
    public long solution(int[] weights) {
        Arrays.sort(weights);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<weights.length; i++){
            map.put(weights[i], map.getOrDefault(weights[i],0)+1);
        }
        //(a,b) 추출 -> a > b
        
        //이분탐색으로 4가지의 경우 찾기
        // 1. a == b
        // 2. 2a == 3b
        // 3. 3a == 4b
        // 4. 2a == 4b => a == 2b
        
        // 1번은 따로 분리해서 n*(n-1)/2로 개수 구하기
        for(Integer key : map.keySet()){
            Integer count = map.get(key);
            if(count > 1){
                answer += (long)count*((long)count-1)/2;
            }
        }
        
        //b는 weights[i]이다.
        for(int i=0; i<weights.length-1; i++){
            int b = weights[i];
            
            binarySearch(weights, map, i+1, weights.length-1, b, 2, 3,i);
            binarySearch(weights, map, i+1, weights.length-1, b, 3, 4,i);
            binarySearch(weights, map, i+1, weights.length-1, b, 1, 2,i); 
        }
        return answer;
    }
    
    void binarySearch(int[] weights, HashMap<Integer,Integer> map, int start, int end, int value, int mulA, int mulB, int index){

        while(start <= end){
            
            int mid = (start + end) / 2;
            //a를 찾는 과정
            if(weights[mid] * mulA == value*mulB){
                // System.out.println("a: " +weights[mid]+"/"+mid + ", b: " + value + "/" + index);
                answer += map.get(weights[mid]);
                return;
            }else if(weights[mid] * mulA > value * mulB){
                end = mid-1;
            }else{
                start = mid+1;
            }    
        }
    }
}