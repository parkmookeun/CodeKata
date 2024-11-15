import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        long[] S = new long[n];
        long[] C = new long[m];

        long answer = 0;
        S[0] = scanner.nextInt();
        for(int i=1; i<n; i++){
            S[i] = S[i-1] + scanner.nextInt();
        }

        for(int i=0; i<n; i++){
            int remainer = (int) (S[i] % m);
            if(remainer == 0) answer++;

            C[remainer]++;
        }
        for(int i=0; i<m; i++){
            if(C[i] > 1){
                answer = answer + (C[i]*(C[i]-1)/2);
            }
        }
        System.out.println(answer);

    }
}