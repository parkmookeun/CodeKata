//핵심 아이디어: 원형 수열 표현을 어떻게 할 건지 & 중복 값 제외 (Set)
// -> i = 0 부터 n-1까지 반복하는 for문 안에 idx 선언
// 선언한 idx가 i가 되기 전까지 값 추가 
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        int start = 0;
        int temp = 0;
        
        Set<Integer> sets = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            //시작점
            start = i;
            temp = elements[i];
            sets.add(elements[i]);
            
            start += 1;
            
            if(start >= elements.length){
                    start = 0;
            }
            
            //시작점으로 다시 돌아올때까지 가능한 수 sets에 추가
            while(start != i){
                temp += elements[start];
                sets.add(temp);
                start++;
                
                if(start >= elements.length){
                    start = 0;
                }
            }
        }
        
        answer = sets.size();
        
        return answer;
    }
}