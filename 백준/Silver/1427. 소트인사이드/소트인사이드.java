

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();

        int[] arr = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();

        selectSort(arr);

        for (int i : arr) {
            System.out.print(i);
        }

    }

    private static void selectSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++){
            int maxIdx = i;
            for(int j=i; j<arr.length; j++){
                if(arr[maxIdx] < arr[j]){
                    maxIdx = j;
                }
            }

            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

}
