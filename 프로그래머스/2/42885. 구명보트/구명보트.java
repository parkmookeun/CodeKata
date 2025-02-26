//아이디어 : 가장 무거운 사람과 가벼운 사람이 같이 타야 한다.
// 정렬 + 투 포인터
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0;
        int right = people.length-1;
        
        Arrays.sort(people);
        
        while(left <= right){
            if(people[left] + people[right] > limit){
                right -= 1;
                answer += 1;
            }else{
                left += 1;
                right -= 1;
                answer += 1;
            }
        }
        
        
        
        return answer;
    }
}