import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        //명예의 전당에 값을 넣고
        //정렬을 시킨다. k번째 인덱스에 있는 값을 정답배열에 넣는다.
        
        
        //정답 배열
        int[] answer = new int[score.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            
            list.add(score[i]);
            list.sort(Comparator.reverseOrder());
            
            answer[i] = i < k ? list.get(i) : list.get(k-1);
            
        }

        return answer;
    }
}