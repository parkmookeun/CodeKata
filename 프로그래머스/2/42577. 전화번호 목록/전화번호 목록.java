//핵심 아이디어 : 문자열 배열을 정렬 + 첫 인덱스 부터 검사
import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        //접두어가 될 인덱스
        int prefixIdx = 0;
        boolean isPrefix = false;
        for(int i=1; i<phone_book.length; i++){
            isPrefix = true;
            for(int j=0; j<phone_book[prefixIdx].length(); j++){
                if(phone_book[i].charAt(j) != phone_book[prefixIdx].charAt(j)){
                    prefixIdx++;
                    isPrefix = false;
                    break;
                }
            }
            if(isPrefix) { answer = false; }
        }
        return answer;
    }
}