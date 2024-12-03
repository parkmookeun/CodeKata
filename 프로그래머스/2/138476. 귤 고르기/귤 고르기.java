import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] arr = new int[10000001];
        
        int answer = 0;
        
        for (int j : tangerine) {
            arr[j] += 1;
        }

        Arrays.sort(arr);
        
        for(int i=arr.length-1; i>=0; i--){
            k -= arr[i];
            answer += 1;
            if(k <= 0) break;
        }

        return answer;
    }
}