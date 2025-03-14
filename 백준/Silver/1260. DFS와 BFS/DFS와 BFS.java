

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        int N,M,V;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        queue = new LinkedList<>();

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
            A[e].add(s);
        }

        for(int i=1; i<N+1; i++){
            Collections.sort(A[i]);
        }

        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);

    }

    private static void BFS(int v) {
        queue.add(v);

        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            visited[poll] = true;
            System.out.print(poll+" ");
            for(int node : A[poll]){
                if(!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }

    private static void DFS(int v) {
        visited[v] = true;
        System.out.print(v+" ");
        for(int node : A[v]){
            if(!visited[node]){
                DFS(node);
            }
        }
    }
}
