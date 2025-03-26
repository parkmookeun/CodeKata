// 핵심 아이디어 : 실제 체육복을 빌려줄 수 있는 친구들 판단 + 왼쪽,오른쪽 어디를 기준으로 잡을지?

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //진짜 빌려줄 수 있는 친구들
        int[] friends = new int[n+1];
        
        Arrays.fill(friends,1);
        
        // server 초기화
        for(int i=0; i<lost.length; i++){
            friends[lost[i]] -= 1;
        }
        
        for(int i=0; i<reserve.length; i++){
            friends[reserve[i]] += 1;
        }
        
        //초기화 후에 현재 체육복 있는 친구들 검사
        int answer = 0;
        for(int i=1; i<friends.length; i++){
            if(friends[i] >= 1) answer++;
        }
        //lost를 돌면서 왼쪽부터 빌릴 수 있는지 검사 후, 없으면 오른쪽에서 빌릴 수 있는지 검사
        //기준으로 왼쪽 다음 오른쪽으로 정했기 때문에 lost배열 정렬
        //예를 들어 1 2 3 4 가 있을 때, lost가 [3,1]이고, reserve가 [2,4]라면
        // 왼쪽부터 여벌옷을 찾기 때문에, 3은 2번의 옷을 가져오게 되는데, 그렇게 되면 1번은 옷을 받을 수 없다.
        // 따라서 lost를 먼저 정렬하고 내가 정한 기준을 적용하면 된다.
        Arrays.sort(lost);
        
        for(int i=0; i<lost.length; i++){
            
            if(friends[lost[i]] > 0) continue;
            
            if((lost[i]-1) > 0 && friends[lost[i]-1] > 1){
                friends[lost[i]-1] -= 1;
                answer++;
            }else if((lost[i]+1) <= n && friends[lost[i]+1] > 1){
                friends[lost[i]+1] -= 1;
                answer++;
            }
        }
        
        return answer;
    }
}