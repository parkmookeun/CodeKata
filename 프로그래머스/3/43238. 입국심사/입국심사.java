//핵심 아이디어 : 모든 사람이 통과할 수 있는 최소 시간의 범위를 어떻게 구할 것인가?
// 이진탐색 + 그리디?
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // Arrays.sort(times);
        
        long start = 1;
        long end = times[times.length-1] * (long)n;
        
        while(start <= end){
            
            long count = 0;
            long mid = (start + end) / 2;
            
            for(int i=0; i<times.length; i++){
               count += (mid / times[i]);
            }
            
            if(count >= n){
                end = mid - 1;
                answer = mid;
            }else{
                start = mid + 1;
            }
        }
        
        return answer;
    }
}