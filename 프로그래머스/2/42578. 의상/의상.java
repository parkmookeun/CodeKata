import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        //모든 경우의 수는 a가 3개 , b가 4개 , c가 2개 있을 때
        //각각의 값에 1을 더한 경우의 수를 모두 곱한 값과 같다.
        //(3+1) * (4 + 1) * (2+ 1) = 60 안입은 경우는 빼야하기 때문에 - 1 -> 59가지 경우의 수
        Map<String,Integer> clothesCount = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            clothesCount.put(clothes[i][1], clothesCount.getOrDefault(clothes[i][1],0)+1);
        }

        for (String s : clothesCount.keySet()) {
            answer *= clothesCount.get(s) + 1;
        }

        return answer-1;
    }
}