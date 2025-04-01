
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }

        //전체 합
        int totalSum = 0;

        while(pq.size() > 1){
            int n1 = pq.poll();
            int n2 = pq.poll();

            totalSum = totalSum + (n1 + n2);
            pq.add(n1+n2);
        }

        System.out.println(totalSum);
    }
}
