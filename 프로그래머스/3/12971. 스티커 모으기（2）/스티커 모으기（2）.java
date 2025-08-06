
import java.util.Arrays;

/**
 *
 */
class Solution {
    public static int solution(int sticker[]) {
        int n = sticker.length;
        
        if(n == 1){
            return sticker[0]; 
        }
        
        if(n <= 3){
            return sticker[0] > sticker[1] ? sticker[0] : sticker[1];
        }
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        //dp1 초기화
        dp1[0] = sticker[0];
        dp1[1] = 0;
        dp1[2] = dp1[0] + sticker[2];
        //dp2 초기화
        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];
        
        int maxValue = dp1[2] > dp2[1] ? dp1[2] : dp2[1];
        
        for (int i = 3; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + sticker[i];
        }

        for (int i = 3; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + sticker[i];
        }

        // System.out.println("dp1 = " + Arrays.toString(dp1));
        // System.out.println("dp2 = " + Arrays.toString(dp2));

        for (int i : dp1) {
            maxValue = Math.max(maxValue, i);
        }

        for (int i : dp2) {
            maxValue = Math.max(maxValue, i);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int solution = solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10});
        System.out.println("solution = " + solution);
    }
}