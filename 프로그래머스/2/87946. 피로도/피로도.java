class Solution {
    private static int maxCount = 0;
    public  int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];

        //출발을 던전의 모든 곳에서 출발
        for(int i=0; i< dungeons.length; i++){
            if(k >= dungeons[i][0]) {  // 초기 조건 체크
                visited = new boolean[dungeons.length];  // visited 초기화
                dfs(i, dungeons, visited, 1, k - dungeons[i][1]);  // 첫 던전의 피로도 차감
            }
        }
        answer = maxCount;
        return answer;
    }

    private  void dfs(int idx, int[][] dungeons, boolean[] visited, int count, int k) {
        visited[idx] = true;
        maxCount = Math.max(maxCount,count);

        //안들른 곳 모두 들르기
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                dfs(i,dungeons,visited,count+1,k - dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}