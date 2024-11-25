import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);

        if(arr.length == 1){
            return arr[0];
        }

        int value = findLCM(arr[0],arr[1]);

        for(int i=2; i<arr.length; i++){
            value = findLCM(value,arr[i]);
//            System.out.println(value);
        }
        return value;
    }

    int findLCM(int a, int b){
        int til = Math.min(a, b);
        int gcd = 1;
//        System.out.println("a,b " + a +", "+ b);
        for(int i=1; i<=til; i++){
            if( a % i == 0 && b % i == 0) gcd = i;
        }
//        System.out.println("최소공배수: " + a * b / gcd);
        return a * b / gcd;
    }
}