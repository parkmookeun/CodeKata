

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //N개의 수가 주어졌을 때 오름 차순
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Data[] arr = new Data[N];

        for(int i=0; i<N; i++){
            arr[i] = new Data(Integer.parseInt(br.readLine()),i);
        }

        //먼저 정렬
        Arrays.sort(arr);

        int max = 0;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i].idx-i);
        }

        System.out.println(max+1);
    }

}
class Data implements Comparable<Data>{
    public int value;
    public int idx;

    public Data(int value, int idx){
        this.idx = idx;
        this.value = value;
    }

    @Override
    public int compareTo(Data o) {
        return value - o.value;
    }
}