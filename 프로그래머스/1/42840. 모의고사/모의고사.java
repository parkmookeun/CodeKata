import java.util.*;

class Solution {
   public static int[] solution(int[] answers) {
        int[] a_an = {1,2,3,4,5};
        int[] b_an = {2,1,2,3,2,4,2,5};
        int[] c_an = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];

        for(int i=0; i<answers.length; i++){
            if(answers[i] == a_an[i%a_an.length]) score[0]++;
            if(answers[i] == b_an[i%b_an.length]) score[1]++;
            if(answers[i] == c_an[i%c_an.length]) score[2]++;
        }
        int maxValue = Math.max(score[0],Math.max(score[1],score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxValue == score[0]) list.add(1);
        if(maxValue == score[1]) list.add(2);
        if(maxValue == score[2]) list.add(3);
        return list.stream().mapToInt(i->i).toArray();
    }
}