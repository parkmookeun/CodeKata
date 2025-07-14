/*
    핵심 아이디어 : 반복문을 돌면서 아래의 내용을 진행
    
    1. 현재 시간에 종료될 서버 종료시키기
    2. 증설될 서버 계산하기
    3. 증설될 서버가 있으면 종료시간 배열에 저장
    
    
    자료구조 -> 종료될 시간을 저장할 배열 필요
    
*/
class Solution {
    public int solution(int[] players, int m, int k) {
        
        //종료될 시간을 저장할 배열
        int[] serverEndTime = new int[24];
        
        //현재 증설된 서버를 저장할 변수
        int server = 0;
        //정답을 저장할 변수
        int answer = 0;
        
        for(int i=0; i<players.length; i++){
            
            //종료된 서버 검사
            server -= serverEndTime[i];
            
            //증설될 서버 계산
            int increase = 0;
            if(players[i] >= m * server){
                increase = players[i] / m - server;
                server += increase;
                answer += increase;
            }
            
            //종료될 시간 저장
            if(i + k < 24){
                serverEndTime[i+k] += increase;
            }
            
            // System.out.println("게임 이용자 수: " + players[i]);
            // System.out.println("증설된 서버 수: " + (server-1));
            // System.out.println("증설 횟수    :  " + answer);
            // System.out.println("===========================");
        }
        
        return answer;
    }
}