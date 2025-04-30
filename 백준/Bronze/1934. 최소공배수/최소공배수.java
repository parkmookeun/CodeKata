
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // A > B 가 되게 서로 스왑
            int max = Math.max(A,B);
            int min = Math.min(A,B);

            while(max % min != 0){
                int result = max % min;

                max = min;
                min = result;
            }

            int result = (A / min) * (B / min) * min;

            System.out.println(result);
        }
    }
}
