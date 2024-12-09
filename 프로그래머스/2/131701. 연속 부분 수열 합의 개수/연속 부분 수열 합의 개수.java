import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        //[][] 각각 길이와 시작 인덱스
        int[][] subTotal = new int[elements.length+1][elements.length];
        Set<Integer> set = new HashSet<>();
        //초기화
        for(int i=0; i<elements.length; i++){
            subTotal[1][i] = elements[i];
            set.add(subTotal[1][i]);
//            System.out.println(subTotal[1][i]);
        }
        System.out.println("구분");
        //배열에 값 넣기
        for(int i=2; i<=elements.length; i++){
//            System.out.println("길이: " + i);
            for(int j=0; j<elements.length; j++){
                subTotal[i][j] = subTotal[i-1][j]+elements[(j+i-1)%elements.length];
//                System.out.println(subTotal[i][j]);
                set.add(subTotal[i][j]);
            }
        }

        answer = set.size();
        return answer;
    }
}