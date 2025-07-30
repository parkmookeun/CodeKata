import java.util.Arrays;

/**
 * 집에서 학교까지의 최단거리 개수를 구하는 문제
 * 아래와 오른쪽으로만 갈 수 있음
 * dp배열을 m * n 크기로 생성을 하고, 먼저 가장자리를 초기화(ㅁ가 배열이라고 하면 왼쪽하고 오른쪽 초기화)
 * 그 다음은, (i,j)위치의 최단거리 개수는 dp[i][j] = dp[i][j-1] + dp[i-1][j]
 * 단 물 웅덩이 체크하는 로직 추가
 */
class Solution {

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        //dp 배열 생성 및 초기화(물이 잠긴 지역도 포함)
        int[][] dp = new int[n][m];
        // 물 웅덩이는 -1로 초기화
        for (int[] pos : puddles) {
            dp[pos[1] - 1][pos[0]-1] = -1;
        }

        initFirstRowAndCol(n, m, dp);

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){

                if(dp[i][j] == -1) continue;
                calculateCase(dp, i, j);
            }
        }

        answer = dp[n-1][m-1] == -1 ? 0 : dp[n-1][m-1];
        return answer;
    }

    private static void initFirstRowAndCol(int n, int m, int[][] dp) {
        int initValue = 1;
        for (int i = 0; i < n; i++) {
            if(dp[i][0] == -1){
                initValue = -1;
            }
            dp[i][0] = initValue;
        }
        initValue = 1;
        for (int i = 0; i < m; i++) {
            if(dp[0][i] == -1){
                initValue = -1;
            }
            dp[0][i] = initValue;
        }
    }

    private static void calculateCase(int[][] dp, int i, int j) {
        // 왼쪽과 위쪽이 모두 물 웅덩이인 경우 -> 최단거리가 올수 없으므로 똑같이 -1 할당
        if(dp[i][j -1] == -1 && dp[i -1][j] == -1){
            dp[i][j] = -1;
        }// 둘 중 한곳이 물 웅덩이인 경우 다른 한쪽의 값 그대로 할당
        else if(dp[i -1][j] == -1){
            dp[i][j] = dp[i][j -1];
        }else if (dp[i][j -1] == -1){
            dp[i][j] = dp[i -1][j];
        }// 둘 다 물 웅덩이가 아닌 경우는 두 경우의 수 합
        else{
            dp[i][j] = (dp[i][j -1] + dp[i -1][j]) % 1_000_000_007;
        }
    }

    public static void main(String[] args) {
        int solution = solution(4, 3, new int[][]{{2, 2}});
        System.out.println("solution = " + solution);
    }
}