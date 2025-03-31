
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            binarySearch(arr, Integer.parseInt(st.nextToken()));
        }
    }

    private static void binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start + end) / 2;

            if(arr[mid] == target){
                System.out.println(1);
                return;
            }else if(arr[mid] > target){
                end = mid-1;
            }else {
                start = mid + 1;
            }
        }

        System.out.println(0);

    }
}
