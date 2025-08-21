import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] graph;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //테스트 케이스 개수 입력 받기
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            graph = new List[V+1];
            check = new int[V+1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();

                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            //DFS 진행
            boolean[] visited = new boolean[V+1];

            for (int k = 1; k <= V; k++) {
                if (isEven) {
                    DFS(k, visited);
                } else {
                    break;
                }
            }

            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int node, boolean[] visited) {
        visited[node] = true;
        for (int i : graph[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i, visited);
            } else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }
}
