
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] meetings = new int[N][2];

        for(int i=0; i<N; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            meetings[i][0] = s;
            meetings[i][1] = e;
        }

        Arrays.sort(meetings,(o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int end = 0;
        int count = 0;
        for(int i=0; i<N; i++){
            if(meetings[i][0] >= end){
                count += 1;
                end = meetings[i][1];
            }
        }

        System.out.println(count);
    }
}
