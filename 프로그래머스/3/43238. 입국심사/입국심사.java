import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long start = 1;
        long end = times[times.length-1] * (long)n;
        
        
        
        while(start <= end){
            // System.out.println(start+", "+end);
            
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