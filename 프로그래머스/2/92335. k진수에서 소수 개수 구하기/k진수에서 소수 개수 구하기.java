//핵심 아이디어 : k 진수로 바꾼 문자열을 split으로 배열 만듦 + 배열 길이 구하기
class Solution {
    public int solution(int n, int k) {
        String[] strArr = convertToRadix(n,k).split("0");
        
        int answer = 0;
        
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].equals("")) continue;
            
            if(isPrime(strArr[i])) answer++;
        }
        
        return answer;
    }
    
    String convertToRadix(int number, int radix){
        String value = "";

        if(number == 0) value = "0";

        while(number > 0){
            int rest = number % radix;     
            value = (number % radix) + value;
            number /= radix;
        }
        return value;
    }
    
    boolean isPrime(String number){
        
        Long n = Long.parseLong(number);
        
        if(n == 1) return false;
        
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
}