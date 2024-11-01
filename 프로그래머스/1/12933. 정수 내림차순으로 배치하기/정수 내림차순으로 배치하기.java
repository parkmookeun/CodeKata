class Solution {
    public long solution(long n) {
        //자릿수가 몇번 나왔는지 담을 배열 0~9
        int[] digit = new int[10];
        
        //정답 변수
        String answer = "";
        
        //자릿수 하나씩 분할해서 배열에 넣어준다.
        while(n>0){
            digit[(int)(n%10)] += 1;
            n /= 10;
        }
        //배열에 있는 수를 내림차순으로 정렬
        for(int i = digit.length-1; i>=0; i--){
            for(int j=0; j<digit[i]; j++){
                answer += i;
            } 
        }
        
        return Long.parseLong(answer);
    }
}