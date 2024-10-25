class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int share = 0;
        while (n / a > 0) {
            share = n / a;
            answer += share*b;
            n = n % a;
            n += share * b;
        }
        return answer;
    }
}