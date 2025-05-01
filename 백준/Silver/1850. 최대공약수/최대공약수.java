
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //결국 길이를 나타내는 두 수의 최대 공약수는 A와B의 최대 공약수의 길이를 나타낸다.
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long result = A > B ? gcd(A,B) : gcd(B,A);

        StringBuilder sb = new StringBuilder();

        for(long i = 0; i<result; i++){
            sb.append("1");
        }

        System.out.println(sb);
    }

    static long gcd(long A, long B){
        long rest = A % B;

        if(rest == 0) return B;
        else return gcd(B, rest);
    }
}
