import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        //3000 까지 소수를 찾아서 소수인지 아닌지 계산
        boolean[] isPrime = new boolean[3001];
        Arrays.fill(isPrime,true);
        for(int i=2; i<=3001; i++){
            for(int j=i*2; j<=3001; j+=i){
                isPrime[j] = false;
            }
        }
        //3개의 숫자를 더했을 때 소수가 되는...
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    if(isPrime[nums[i]+nums[j]+nums[k]]){
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }
}