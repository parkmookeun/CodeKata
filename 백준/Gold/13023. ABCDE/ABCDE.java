
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static boolean arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N];
        arrive = false;

        for(int i=0; i<N; i++){
            A[i] = new ArrayList<>();
        }
        visited = new boolean[N];


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2);
            A[node2].add(node1);
        }

        for(int i=0; i<N; i++){
            DFS(i,1);

            if(arrive) break;
        }

        if(arrive){
            System.out.println("1");
        }else{
            System.out.println("0");
        }




    }

    private static void DFS(int now, int depth) {

        if(depth == 5 || arrive){
            arrive = true;
            return;
        }
        visited[now] = true;
        for (int path : A[now]){
            if(!visited[path]){
                DFS(path,depth+1);
            }
        }
        visited[now] = false;
    }
}
