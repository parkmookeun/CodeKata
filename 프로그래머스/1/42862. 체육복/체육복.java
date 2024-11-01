import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //학생들 체육복 수 체크
        int[] students = new int[n+1];
        Arrays.fill(students,1);
        //lost 체크
        for(int i=0; i<lost.length; i++){
            students[lost[i]] -= 1;
        }

        //reserve 체크
        for(int i=0; i<reserve.length; i++){
            students[reserve[i]] += 1;
        }

        //이제 줄수 있는지 체크
        Arrays.sort(lost);
        for(int i=0; i<lost.length; i++){
            //이미 있으면 넘어가기
            if(students[lost[i]] > 0){
                continue;
            }
            //왼쪽에서 받을 수 있으면 받기
            if(lost[i]-1 > 0 && students[lost[i]-1] > 1){
                students[lost[i]] += 1;
                students[lost[i]-1] -= 1;
                continue;
            }
            //오른쪽에서 받을 수 있으면 받기
            if(lost[i]+1 <= n && students[lost[i]+1] > 1){
                students[lost[i]] += 1;
                students[lost[i]+1] -= 1;
            }
        }
        //이제 체육복을 가진 친구들 세기
        for(int i=1; i<=n; i++){
            if(students[i] >= 1) answer += 1;
        }
        return answer;
    }
}