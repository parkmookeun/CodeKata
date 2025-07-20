import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 핵심 아이디어 : 구현(행렬 회전)
 *
 * 행렬의 테두리를 회전시킨다. (단, 가장 작은 수를 구해 나가며)
**/
class Solution {
    public static int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        int[][] map = new int[rows+1][columns+1];

        int value = 0;
        for (int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++){
                map[i][j] = ++value;
            }
        }

//        for (int[] row : map) {
//            System.out.println(Arrays.toString(row));
//        }

        for (int i = 0; i < queries.length; i++) {
            int minValue = rotateBorder(queries[i][0], queries[i][1], queries[i][2], queries[i][3], map);
            answer.add(minValue);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    // 행렬을 회전시키는 함수
    public static int rotateBorder(int lx, int ly, int rx, int ry, int[][] map) {
        //가장 작은 수를 저장
        int value = (map.length - 1) * (map[0].length - 1) + 1;

        //회전해서 왼쪽 상단, 오른쪽 상단, 왼쪽 하단, 오른쪽 하단에 들어갈 값 미리 저장
        int leftUp = map[lx+1][ly];
        int rightUp = map[lx][ry-1];
        int leftDown = map[rx][ly+1];
        int rightDown = map[rx-1][ry];

        //윗줄 회전
        for (int i = ry - 1; i > ly; i--) {
            map[lx][i] = map[lx][i-1];
            value = Math.min(map[lx][i], value);
        }
        //오른쪽 줄 회전
        for (int i = rx - 1; i > lx; i--) {
            map[i][ry] = map[i-1][ry];
            value = Math.min( map[i][ry], value);
        }
        //아랫줄 회전
        for (int i = ly + 1; i < ry; i++) {
            map[rx][i] = map[rx][i+1];
            value = Math.min( map[rx][i], value);
        }

        //왼쪽 줄 회전
        for (int i = lx + 1; i < rx; i++) {
            map[i][ly] = map[i+1][ly];
            value = Math.min( map[i][ly], value);
        }

        map[lx][ly] = leftUp;
        map[lx][ry] = rightUp;
        map[rx][ly] = leftDown;
        map[rx][ry] = rightDown;

        value = Math.min(Math.min(Math.min(Math.min(value,leftUp), rightUp),leftDown),rightDown);

        // 출력해보기
//        for (int[] row : map) {
//            System.out.println(Arrays.toString(row));
//        }

        return value;
    }
}