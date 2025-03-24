// 핵심 아이디어 : 모든 간선에 대하여, 끊은 연결선의 두 노드에서 각각 dfs 탐색을 하고
// 그 후에 각각의 노드 수의 차를 구하여서 answer를 갱신
import java.util.*;
class Solution {
    //어떤 간선을 끊는다고 했을 때, 해당되는 두 노드 중 왼쪽 노드의 방문 배열 leftVisited 
    //오른쪽 노드의 방문 배열 rightVisited
    boolean[] leftVisited;
    boolean[] rightVisited;
    
    //graph의 정보 저장할 리스트 배열
    ArrayList<Integer>[] graph;
    
    //정답이 될 두 송전탑 차이 개수 -> 처음에는 최대 100으로 초기화
    int count= 100;
    
    //dfs한번 할때마다 송전탑 개수 저장할 변수
    int nodeCount;
    
    public int solution(int n, int[][] wires) {
        
        //그래프 초기화
        graph = new ArrayList[101];
        
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        //간선 하나씩 지우고, dfs 탐색 -> 방문 배열 초기화
        for(int i=0; i<wires.length; i++){
      
            leftVisited = new boolean[101];
            rightVisited = new boolean[101];
            
            leftVisited[wires[i][1]] = true;
            dfs(leftVisited,wires[i][0]);
            int left = nodeCount;
            //송전탑 개수 초기화
            nodeCount = 0;
            
            rightVisited[wires[i][0]] = true;
            dfs(rightVisited,wires[i][1]);
            int right = nodeCount;
            //송전탑 개수 초기화
            nodeCount = 0;
            
            //송전탑 차이 중 최솟값을 count에 저장
            //diff는 i번째 간선을 끊었을 때 송전탑 개수 차이
            int diff = Math.abs(left-right);
            count = count >= diff ? diff : count;  
        }
        
        return count;
    }
    
    void dfs(boolean[] visited, int node){
        visited[node] = true;
        // nodeCount = nodeCount >= count ? nodeCount : count;
        
        for(int bridge : graph[node]){
            if(!visited[bridge]){
              dfs(visited, bridge);
              nodeCount++;
            }
        }   
    }
}