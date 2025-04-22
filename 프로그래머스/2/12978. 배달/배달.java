import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] dist = new int[N+1][N+1];
        
        //최대값으로 일단 초기화 10000 * 2000 + 1
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i],10000 * 2000 + 1);
        }
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i ==j) {
                    dist[i][j] = 0;
                }
            }
        }
        
        //거리 초기화
        for(int i=0; i<road.length; i++){
            dist[road[i][0]][road[i][1]] = Math.min(road[i][2],dist[road[i][0]][road[i][1]]);
            dist[road[i][1]][road[i][0]] = Math.min(road[i][2],dist[road[i][1]][road[i][0]]);
        }
        
        //최단 거리 구하기
        for(int k=1; k<=N; k++){
            for(int j=1; j<=N; j++){
                for(int i=1; i<=N; i++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        
        //마을1까지의 거리가 K이하인 경우 구하기(1번마을 빼고) -> 예를들어 dist[1][k] + dist[k][1]이 K값보다 클수도 있어서
        //일단 2번부터 생각하고 나중에 그냥 + 1 하려고
        for(int i=1; i<=N; i++){
            if(dist[1][i] <= K) answer++;
        }
        
        //1번마을도 포함해서
        return answer;
    }
}