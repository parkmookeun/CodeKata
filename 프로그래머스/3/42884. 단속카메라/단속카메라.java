import java.util.*;

/**
 * 핵심 아이디어: 그리디 알고리즘(진입 지점이 빠른? 지점부터 검사)
 *
 * 1. 진입지점이 빠른 순으로(작은 순)으로 정렬
 * 2. 큐에서 하나씩 꺼내면서 범위가 겹치지 않으면 큐에 넣기(겹치지 않으면 결국 설치해야하므로)
 * 3. 겹치면 겹치는 부분으로 진입지점과 진출지점을 갱신해주기
 *    (시작지점: 새로 들어온 차량의 진입지점, 진출지점: 기존 차량의 진출지점)
 * 4. 마지막에 큐 사이즈 반환
 */
class Solution {
    public static int solution(int[][] routes) {
        //검사하면서 넣어줄 큐
        List<int []> queue = new LinkedList<>();
        //차량을 넣을 리스트
        List<int[]> list = new ArrayList<>(Arrays.asList(routes));
        
        //리스트 진입 지점 오름차순으로 정렬
        list.sort(Comparator.comparingInt(a -> a[0]));
        
        for (int[] car : list) {
            //큐에 아무것도 없으면 넣기
            if (queue.isEmpty()) {
                queue.add(car);
                continue;
            }
            // 값 꺼내기
            int[] peek = queue.get(0);
            //겹치지 않으면 넣기
            if (peek[1] < car[0]) {
                queue.add(0,car);
                continue;
            }
            //겹치면 갱신
            peek[0] = car[0];
            peek[1] = Math.min(peek[1], car[1]);
        }
        return queue.size();
    }
}