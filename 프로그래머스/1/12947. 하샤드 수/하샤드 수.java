class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        //자릿수 합과 숫자 x 저장
        int digitSum = 0;
        int originNum = x;
        
        //x의 자릿수 합을 구하기 위한 연산
        while (x > 0) {
            digitSum += x%10;
            x /= 10;
        }
        //자릿수 합으로 숫자 x가 나누어지면...
        if (originNum % digitSum == 0) {
            answer = true;
        } 
        
        return answer;
    }
}