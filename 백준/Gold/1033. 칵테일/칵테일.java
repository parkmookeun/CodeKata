
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static boolean[] visited;
    static ArrayList<Node>[] A;
    static long[] D;
    public static void main(String[] args) throws IOException {
        long lcm = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        A = new ArrayList[N];
        for(int i=0; i<N; i++){
            A[i] = new ArrayList<>();
        }
        //비율대로 초기화
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));

            lcm *= p * q /gcd(p,q);
        }

        D = new long[N];
        visited = new boolean[N];

        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];

        //최대공약수를 찾는다.
        for(int i=0; i<N; i++){
            mgcd = gcd(mgcd, D[i]);
        }

        //최대공약수를 사용해서 원래 양을 출력한다.
        for(int i=0; i<N; i++){
            System.out.print(D[i] / mgcd + " ");
        }
    }

    private static long gcd(long p, long q) {
        if(q == 0) return p;
        else return gcd(q, p%q);
    }
    private static void DFS(int Node){
        visited[Node] = true;
        for(Node i : A[Node]){
            int next = i.getB();
            if(!visited[next]){
                D[next] = D[Node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}
class Node{
    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
