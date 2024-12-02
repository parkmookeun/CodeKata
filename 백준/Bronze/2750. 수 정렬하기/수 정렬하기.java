

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //N개의 수가 주어졌을 때 오름 차순
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        bubbleSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
        
    }
    static void bubbleSort(int[] arr){

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<(arr.length-1)-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
    }
}
