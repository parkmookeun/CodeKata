import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] intArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        OptionalInt maxValue = Arrays.stream(intArr).max();
        OptionalInt minValue = Arrays.stream(intArr).min();
        int max = maxValue.getAsInt();
        int min = minValue.getAsInt();

        answer = min + " " + max;
        return answer;
    }
}