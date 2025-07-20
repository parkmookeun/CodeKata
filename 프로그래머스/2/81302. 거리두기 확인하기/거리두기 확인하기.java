import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 핵심 아이디어 : 구현
 *
 * 1. 먼저 응시자들의 위치 저장
 * 2. 응시자들끼리 짝을 지어서 위치쌍을 만듦
 * 3. 위치쌍을 만들고, 그 위치쌍의 거리가 2이하인 것들만 필터링
 * 4. 필터링 된 위치들을 하나씩 검사해서(파티션 검사) 중간에 파티션이 있으면 통과 없으면 탈락
 */
public class Solution {

    public static int[] solution(String[][] places) {
       List<Integer> answer = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            //응시자들 위치를 저장할 리스트
            List<int []> positions = new ArrayList<>();
            boolean isBlocked = true;
            char[][] map = new char[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    map[j][k] = places[i][j].charAt(k);
                    if(map[j][k] == 'P') positions.add(new int[]{j,k});
                }
            }

//            map 출력해보기
            // for (char[] mapRow : map) {
            //     System.out.println(Arrays.toString(mapRow));
            // }
            // System.out.println();
            // System.out.println();

            //응시자들이 저장된 위치 positions를 가지고 위치쌍을 만듦
            List<int []> pairs = makeAttendantPair(positions);

//            System.out.println("응시자 쌍 출력 해보기");
//            for (int[] pair : pairs) {
//                System.out.println(Arrays.toString(pair));
//            }

            //여기서 파티션 검사
            for (int[] position : pairs) {
                if(!isBlocked(position, map)){
                    isBlocked = false;
                    break;
                }
            }

            if(isBlocked) answer.add(1);
            else answer.add(0);

        }

        return answer.stream().mapToInt(i -> i).toArray();
    }


    // int[4]의 크기로 위치의 쌍 만들기
    private static List<int[]> makeAttendantPair(List<int[]> positions) {
        List<int []> pairs = new ArrayList<>();
        for (int i = 0; i < positions.size() - 1; i++) {
            int[] first = positions.get(i);
            for (int j = i + 1; j < positions.size(); j++) {
                int[] second = positions.get(j);
                //맨헤튼 거리가 2이하 일때
                if(getManhattan(first[0],first[1],second[0],second[1]) <= 2)
                    pairs.add(new int[]{first[0],first[1],second[0],second[1]});
            }
        }
        return pairs;
    }

    public static int getManhattan(int x1, int y1, int x2, int y2){
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }

    //파티션이 있는지 검사
    private static boolean isBlocked(int[] position, char[][] map) {


        //첫번째 위치와 두번째 위치는 1 -> 2 또는 1    또는       1 밖에 없다.
//                                              2        2
        int x1 = position[0];
        int y1 = position[1];
        int x2 = position[2];
        int y2 = position[3];

        //거리 1이면 return false
        if(getManhattan(x1, y1, x2, y2) == 1) return false;


        if(x1 == x2){
            return map[x1][y1 + 1] == 'X';
        }
        else if(y2 != y1){
            if(map[x1][y2] == 'X' && map[x2][y1] == 'X') return true;
        }else {
            if(map[x1+1][y1] == 'X') return true;
        }
        return false;
    }
}