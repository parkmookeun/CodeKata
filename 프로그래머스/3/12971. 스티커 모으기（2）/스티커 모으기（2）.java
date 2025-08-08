import java.util.Arrays;

/**
 * 핵심 아이디어 : 첫번째 요소를 선택한 경우와 선택 안한 경우의 DP를 각각 구해, 그 중 큰 값을 반환한다.
 * 
 * dp[i] = Math.max(dp[i-2], dp[i-3]) + sticker[i]로 초기화를 했다.
 * i-2와 i-3 중에서 비교를 한 이유는 일단 i-1은 바로 전 인덱스라서 값을 가져올 수 없고, 2칸 전, 3칸 전까지는 값을 가져올 수 있다.
 * 4칸 전은 2칸 전의 값에 이미 포함이 되어있기 때문에,,, 그 이후는 상관 x
 * 
 * dp를 다 돌리고 나온 문제가 첫번째 칸을 포함하냐 안하냐에 의해서 최댓값이 달라지게 됨
 * 1번째 칸을 포함하면 마지막 요소를 제외시켜야하는데,, dp의 마지막에 와서 그 최댓값이 1번째 칸을 포함한 값인지 알수 없기 때문에,, 결국 1번째 칸을 포함하냐 안하냐에 따라 DP의 값들이 다 달라지게 된다.
 
 * (사실 상, 첫번째 칸이라는 기준은 다른 칸으로도 달라질 수 있다. 그렇지만 그렇게 되면 한바퀴를 돌때 인덱스 관련 귀찮아 지므로)
 
 * 따라서 1번째 칸을 포함하지 않는 DP도 또 따로 구해서 두 DP의 최댓값 중 큰 값을 반환
 */
class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if(n == 1){
            return sticker[0];
        }

        if(n == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        
        if(n == 3){
            return Math.max(sticker[2],Math.max(sticker[0], sticker[1]));
        }
                   
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        //dp1 초기화 -> 1번째 값 포함
        dp1[0] = sticker[0];
        dp1[1] = 0;
        dp1[2] = dp1[0] + sticker[2];
        //dp2 초기화 -> 1번째 값 미포함
        dp2[0] = 0;
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];


        for (int i = 3; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + sticker[i];
        }

        for (int i = 3; i < sticker.length; i++) {
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + sticker[i];
        }

        // System.out.println("dp1 = " + Arrays.toString(dp1));
        // System.out.println("dp2 = " + Arrays.toString(dp2));
        int maxValue = 0;

        for (int i : dp1) {
            maxValue = Math.max(maxValue, i);
        }
            
        for (int i : dp2) {
            maxValue = Math.max(maxValue, i);
        }

        return maxValue;
    }
}