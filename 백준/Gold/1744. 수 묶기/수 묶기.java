
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();

        int one = 0;
        int zero = 0;
        for(int i=0; i<N; i++){
            int value = sc.nextInt();

            if(value == 1){
                one += 1;
            }
            else if(value == 0){
                zero += 1;
            }else if(value > 1){
                plusQ.add(value);
            }else{
                minusQ.add(value);
            }
        }

        int answer = 0;

        while(plusQ.size() > 1){
            int n1 = plusQ.poll();
            int n2 = plusQ.poll();

            answer += n1*n2;
        }

        if(!plusQ.isEmpty()){
            answer += plusQ.poll();
        }


        while(minusQ.size() > 1){
            int n1 = minusQ.poll();
            int n2 = minusQ.poll();

            answer += n1*n2;
        }

        if(!minusQ.isEmpty()){
            if(zero == 0) answer += minusQ.poll();
        }

        answer += one;

        System.out.println(answer);


    }
}
