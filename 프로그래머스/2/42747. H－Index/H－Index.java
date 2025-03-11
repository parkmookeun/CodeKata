// 핵심 아이디어 : H-Index -> n편 중에서 h번이상 인용된 논문이 h편 이상이면 h 최댓값이 H-Index
// H-Index 0부터 증가!

class Solution {
    public int solution(int[] citations) {
        
        int h_index = 0;
        int qouteCount = 0;
        // 배열의 길이 만큼 검사 -> 최대 배열의 길이이므로 ,,,, 
        for(int i=0; i<=1000; i++){
            
            h_index = i;
            qouteCount = 0;
            // 배열의 길이만큼 인용 수 계산
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= h_index){
                    qouteCount++;
                }
                //인용 수가 기존 h_index 값 넘으면 h_index += 1
                if(qouteCount >= h_index) break;
            }
            
            //전부 검사했는데도 못넘으면 바로 직전의 값이 h_index의 최대
            if(qouteCount < h_index) break;
        }
        return h_index-1;
    }
}