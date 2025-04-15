//이동 명령들을 수행하면서, 가보지 않은 좌표를 구한다.
//set + 범위 제한 신경쓰기
import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        //좌표를 저장할 set
        Set<String> set = new HashSet<>();
        
        //상하좌우를 저장할 맵 -> U: 0 / D: 1 / L: 2 / R:3
        Map<Character, Integer> dirMap = new HashMap<>();
        
        dirMap.put('U',0);
        dirMap.put('D',1);
        dirMap.put('L',2);
        dirMap.put('R',3);
        
        //방향에 따라 움직일 좌표
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        //초기 위치
        int x = 0;
        int y = 0;
        
        for(int i=0; i<dirs.length(); i++){
            int sx = x + dx[dirMap.get(dirs.charAt(i))];
            int sy = y + dy[dirMap.get(dirs.charAt(i))];
            
            if(sx < -5 || sx > 5 || sy < -5 || sy > 5) continue;
            
            set.add(""+x+y+sx+sy);
            set.add(""+sx+sy+x+y);
            
            x = sx;
            y = sy;
        }
                
        return set.size()/2;
    }
}