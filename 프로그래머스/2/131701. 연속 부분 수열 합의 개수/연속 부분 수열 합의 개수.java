//핵심 아이디어: 원형 수열 표현을 어떻게 할 건지 & 중복 값 제외 (Set)
// -> 원형은 배열의 마지막 인덱스 다음 인덱스를 처음으로 다시 돌려주는 로직으로 표현
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