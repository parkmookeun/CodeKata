import java.util.Arrays;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int sIdx = 0;
        boolean[] isPainted = new boolean[n+1]; // 1부터 n까지의 벽이 칠해졌는지 여부
        //벽 상태 초기화
        Arrays.fill(isPainted, true);
        for(int i=0; i<section.length; i++){
            isPainted[section[i]] = false;
        }

        //안칠해진 왼쪽 부터 칠하기
        for(int i=0; i<section.length; i++){
            
            int start = section[i];
            
            boolean toPaint = false;
            
            if(isPainted[start]) continue;
            
            for(int j=start; j<start+m; j++){
                
                if(j<= n && !isPainted[j]){
                    
                    isPainted[j] = true;
                    toPaint = true;
                }
            }
            
            if(toPaint){
                answer += 1;
            }
        }

        return answer;
    }
}