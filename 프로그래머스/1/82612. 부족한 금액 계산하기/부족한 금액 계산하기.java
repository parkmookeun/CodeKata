class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        //N번째 이용시 가격 -> N * price
        //따라서, 총 가격은 1*price + 2*price + 3*price + ... + N*price
        //price로 묶으면 price(1+2+3+4+....+N)
        
        //1부터 N까지의 합을 구한 변수 즉, count까지 합을  구할 변수
        long prefixSum = 0;
        
        for(int i=1; i<=count; i++) prefixSum += i;
        
        //돈계산
        answer = prefixSum * price - money;
        
        if(answer < 0) answer = 0;
        
        return answer;
    }
}