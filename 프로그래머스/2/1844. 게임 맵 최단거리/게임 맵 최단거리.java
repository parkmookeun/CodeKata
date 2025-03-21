// 핵심 아이디어 : n,m 까지 가면서 모든 길을 BFS로 완전 탐색을 한다.
import java.util.*;

class Solution {
    
    //방향 상하좌우를 결정할 배열 -> (x,y)라고 치면 (1,0) : 동 / (-1,0) : 서 / (0,1) : 남 / (0,-1) : 북
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    //maps의 (x,y)의 위치를 넣을 큐
    Queue<int[]> queue;
    
    //방문 배열 visited
    boolean[][] visited;
    
    //정답 칸 수를 저장할 변수
    int count = 0;
    
    public int solution(int[][] maps) {
        
        //방문배열 및 큐 초기화
        visited = new boolean[maps.length][maps[0].length];
        queue = new LinkedList<>();
        
        //bfs탐색 시작
        bfs(0,0,maps);
        
        return count;
    }
    
    void bfs(int x, int y, int[][] maps){
        //큐에 넣어주면서 방문 처리
        queue.add(new int[]{x,y,1});
        visited[x][y] = true;
        
        //큐가 빌때까지
        while(!queue.isEmpty()){
            //위치 하나를 꺼낸다
            int[] node = queue.poll();
            //목적지인지 검사
            if(node[0] == (maps.length-1) && node[1] == (maps[0].length -1)){
                count = node[2];
                break;
            }
                
            //4방향 모두 검사 -> 상 하 좌 우
            for(int i=0; i<4; i++){
                int sx = node[0] + dx[i];
                int sy = node[1] + dy[i];
                
                //가장자리를 벗어나면 어차피 못가니까 예외 처리
                if(sx < 0 || sx >= maps.length || sy < 0 || sy >= maps[0].length) continue;
                
                //방문되지 않은 위치이고 벽이 아니면 큐에 저장
                if(!visited[sx][sy] && maps[sx][sy] == 1){
                    queue.add(new int[]{sx,sy,node[2]+1});
                    visited[sx][sy] = true;
                }
            }
        }
        //만약 큐가 비어 있고 목적지 위치가 아니라면 (count가0이면 한번도 갱신되지 않았으니까 목적지 위치 x)
        if(count == 0){
            count = -1;
        }
    }
}