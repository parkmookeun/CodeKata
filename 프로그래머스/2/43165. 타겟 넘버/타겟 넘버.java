class Solution {
    private static int answer = 0;
    public static int solution(int[] numbers, int target) {
        int currentValue = 0;
        dfs(numbers, target, currentValue, 0);
        return answer;
    }

    private  static void dfs(int[] numbers, int target, int current, int depth) {

        if(depth == numbers.length){
            if(current == target){
                answer += 1;
            }
            return;
        }

        dfs(numbers,target,current+numbers[depth],depth+1);
        dfs(numbers,target,current-numbers[depth],depth+1);

    }
}