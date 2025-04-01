
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] coins = new int[N];

        for(int i=0; i<N; i++){
            coins[N-1-i] = sc.nextInt();
        }

        int answer = 0;
        for(int i=0; i<N; i++){

            if(K == 0) break;

            answer = answer + K/coins[i];
            K = K % coins[i];
        }

        System.out.println(answer);
    }
}
