

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //입력을 한줄로 받고, 그것을 nextToken으로 값을 꺼낸다.
        //한 줄 단위의 입력을 받을 때마다 새로 생성해야한다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        long[] sectionSum = new long[n+1];

        //배열 입력 받기
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i =1; i<= n; i++){
            sectionSum[i] = sectionSum[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }
        //계산 할 줄 입력받기
        for(int i=0; i< m; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(sectionSum[b]-sectionSum[a-1]);
        }
    }

}
