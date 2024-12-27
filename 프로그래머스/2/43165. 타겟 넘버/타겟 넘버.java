class Solution {
    private static int answer = 0;
    public static int solution(int[] numbers, int target) {
        int currentValue = 0;
        dfs(numbers, target, currentValue, 0);
        return answer;
    }

    private  static void dfs(int[] numbers, int target, int current, int depth) {
//        System.out.print(current);

        if(depth == numbers.length){
            if(current == target){
                answer += 1;
            }
//            System.out.println();
            return;
        }

        dfs(numbers,target,current+numbers[depth],depth+1);
        dfs(numbers,target,current-numbers[depth],depth+1);

    }
}