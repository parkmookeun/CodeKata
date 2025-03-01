// 핵심 아이디어: 배열의 최소공배수를 계속 구한다.
import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        int gcd = 1;
        int lcm = gcd*arr[0];
        
        Arrays.sort(arr);
        
        for(int i=1; i<arr.length; i++){
            //배열의 각 요소에 접근
            for(int j=1; j<=arr[i]; j++){
                if(lcm % j == 0 && arr[i] %j == 0){
                    gcd = j;
                }
            }
            //최소공배수 구하기
            lcm = gcd * lcm / gcd * arr[i] / gcd;
            answer = lcm;
        }
        return answer;
    }
}