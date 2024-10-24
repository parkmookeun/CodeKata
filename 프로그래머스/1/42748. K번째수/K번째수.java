import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] subList;
        for(int i=0; i<commands.length; i++){
             subList = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
             Arrays.sort(subList);
             answer[i] = subList[commands[i][2]-1];
        }
        return answer;
    }
}