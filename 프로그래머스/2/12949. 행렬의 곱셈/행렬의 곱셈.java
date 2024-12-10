import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                answer[i][j] = calculate(arr1, arr2, i,j);
            }
        }
        System.out.println(Arrays.deepToString(answer));
        return answer;
    }
    public int calculate(int[][] map1, int[][] map2, int x, int y){
        int value = 0;
        for(int i=0; i<map1[0].length; i++){
            value += map1[x][i] * map2[i][y];
        }
        return value;
    }
}