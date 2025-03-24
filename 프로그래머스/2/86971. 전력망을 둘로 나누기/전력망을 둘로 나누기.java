// 핵심 아이디어 : 모든 간선에 대하여, 끊은 연결선의 두 노드에서 각각 dfs 탐색을 하고
// 그 후에 각각의 노드 수의 차를 구하여서 answer를 갱신
import java.util.*;
class Solution {
    
    boolean[] leftVisited;
    boolean[] rightVisited;
    ArrayList<Integer>[] graph;
    
    int count= 100;
    int nodeCount;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
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
            int left = dfs(leftVisited,wires[i][0],1);
            // System.out.println("왼쪽 값: " + left);
            nodeCount = 0;
            // System.out.println("오른쪽 시작");
            rightVisited[wires[i][0]] = true;
            int right = dfs(rightVisited,wires[i][1],1);
            
            // System.out.println("오른쪽 값: " + right);
            
            int diff = Math.abs(left-right);
            count = count >= diff ? diff : count;
            // System.out.println("현재 송전탑 차이는 " + count);
            // System.out.println();
            nodeCount = 0;
        }
        
        return count;
    }
    
    int dfs(boolean[] visited, int node, int count){
        visited[node] = true;
        // System.out.println("현재 방문한 노드 : " + node +", 현재 count : " + (count));
        nodeCount = nodeCount >= count ? nodeCount : count;
        
        for(int bridge : graph[node]){
            if(!visited[bridge]){
              count = dfs(visited, bridge, count+1);
            }
        }   
        return nodeCount;
    }
}