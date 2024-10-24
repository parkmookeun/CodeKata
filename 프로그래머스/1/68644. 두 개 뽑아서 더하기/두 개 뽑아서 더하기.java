import java.util.*;

class Solution {
    public int[] solution(int[] numbers){
        Set<Integer> sets = new HashSet<>();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                sets.add(numbers[i]+numbers[j]);
            }
        }
        List<Integer> answerList = new ArrayList<>(sets);
        Collections.sort(answerList);
        int[] answer = new int[answerList.size()];
        int idx = 0;
        for (Integer i : answerList) {
            answer[idx++] = i;
        }
        return answer;
    }
}