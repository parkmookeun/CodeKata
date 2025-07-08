/*
    핵심아이디어 : 비트를 1-2개 다른 수들 중에서 제일 작은 수를 어떻게 구할것인가?
    
    이진수를 나눠서 생각할 수 있다. 3가지로
    
    1. 1111 -> 무조건 1로만 이루어진 수
      이 경우에는 기존의 1을 0으로 바꾸면 숫자가 오히려 작아지므로,
      자릿수를 하나 올려야한다. 그리고 기존의 최댓 자리수의 자리를 0으로 바꾼다.
      
    2. ...1110 -> 마지막에 0이 있는 경우
      이 경우에는 그냥 +1이 가장 작은 큰수이다.
    3. ...1011 -> 0이 중간에 있는 경우
      이 경우는 뒤에서부터 0을 찾는다. 그리고 그 0을 1로 바꿔주고, 그 전 1을 0으로 바꿔준다.
    
*/
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            long n = numbers[i];
            String binaryString = Long.toBinaryString(n);
            StringBuilder sb;
            
            // 케이스 1의 경우
            if(n > 0 && (n & (n + 1)) == 0){
                sb = new StringBuilder(binaryString);
                sb.setCharAt(0,'0');
                sb.insert(0,'1');
                answer[i] = Long.parseLong(sb.toString(),2);
                continue;
            }
            //케이스 2의 경우 중 끝이 0인 경우
            if(n % 2 == 0){
                answer[i] = n+1;
                continue;
            } 
            
            //케이스 2의 나머지 경우
            sb = new StringBuilder(binaryString);
            int zeroIdx = binaryString.lastIndexOf('0');
            sb.setCharAt(zeroIdx,'1');
            sb.setCharAt(zeroIdx+1,'0');
            answer[i] = Long.parseLong(sb.toString(),2);
        }
        
            
        return answer;
    }
}