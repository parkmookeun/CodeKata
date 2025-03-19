// 핵심 아이디어 : n,m 까지 가면서 모든 길을 BFS로 완전 탐색을 한다.
import java.util.*;

class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    Queue<int[]> queue;
    boolean[][] visited;
    
    int count = 0;
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        queue = new LinkedList<>();
        
        bfs(0,0,maps);
        
        return count;
    }
    
    void bfs(int x, int y, int[][] maps){
        queue.add(new int[]{x,y,1});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
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
                
                if(sx < 0 || sx >= maps.length || sy < 0 || sy >= maps[0].length) continue;
                
                if(!visited[sx][sy] && maps[sx][sy] == 1){
                    queue.add(new int[]{sx,sy,node[2]+1});
                    visited[sx][sy] = true;
                }
            }
        }
        if(queue.isEmpty() && count == 0){
            count = -1;
        }
        
    }
}