class Solution {
    public int solution(int[] citations) {
        
        int h_index = 0;
        int qouteCount = 0;
        
        for(int i=0; i<=1000; i++){
            h_index = i;
            qouteCount = 0;
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= h_index){
                    qouteCount++;
                }
                if(qouteCount >= h_index) break;
            }
            
            if(qouteCount < h_index) break;
        }
        
        return h_index-1;
    }
}