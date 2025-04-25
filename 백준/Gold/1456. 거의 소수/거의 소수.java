
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        // 10^14의 제곱근은 10^7이므로, 10^7까지의 소수를 찾으면 됩니다.
        int limit = 10000000;
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // 에라토스테네스의 체 수정
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                // 소수의 제곱(N>=2)부터 계산
                long value = (long) i * i; // 제곱부터 시작

                while (value <= B) {
                    if (value >= A) {
                        count++;
                    }

                    // overflow 체크
                    if (value > B / i) {
                        break;
                    }

                    value *= i;
                }
            }
        }

        System.out.println(count);
    }
}