import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;
class Solution {
    class Route{
        int k;
        int cnt;
        boolean[] visited;
        
        public Route(int k, int cnt, boolean[] visited){
            this.k = k;
            this.cnt = cnt;
            this.visited = visited;
            
        }
    }
    public int solution(int k, int[][] dungeons) {
        int answer = -1;

        Deque<Route> queue = new LinkedList<>();
        boolean[] visited = new boolean[dungeons.length];
        //k 피로도 cnt 클리어던전개수, visited
        int cnt = 0;
        
        queue.add(new Route(k,cnt,visited));

        while(!queue.isEmpty()){

            Route route= queue.poll();
            answer=Math.max(answer,route.cnt);


            for(int i=0;i<dungeons.length;i++){
                boolean[] tempV=Arrays.copyOf(route.visited,dungeons.length);
                if(tempV[i]!=true && route.k>=dungeons[i][0]){//안가본곳이고 k가최소피로도보다 높다면
                    tempV[i]=true;

                    queue.add(new Route(route.k-dungeons[i][1],route.cnt+1,tempV.clone()));
                }
            }
        }


        return answer;
    }
}