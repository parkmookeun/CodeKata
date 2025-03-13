// DFS - 완전 탐색
// 모든 던전을 시작 던전으로 돌면서, 최대 가능 던전 수 구하기
class Solution {
    static boolean[] visited;
    static int count;
    
    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        
        for(int i=0; i<dungeons.length; i++){
            if(dungeons[i][0] <= k){
                dfs(i,k,1,dungeons);    
            }
        }
        
        return count;
    }
    //dfs 탐색 함수
    void dfs(int idx, int fatigue, int depth, int[][] dungeons){
        
        count = Math.max(count,depth);
        
        //탐색할 수 있으면
        visited[idx] = true;
        fatigue -= dungeons[idx][1];
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && fatigue >= dungeons[i][0]){
                dfs(i,fatigue, depth+1, dungeons);
            }
        }
        visited[idx] = false;
    }
}