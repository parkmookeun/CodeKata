class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int row = 0;
        int col = 0;
        
        for(int i=1; i<= (int)(Math.sqrt(yellow)); i++){
            if(yellow % i == 0){
                col = i;
                row = yellow / col;        
                
                if(((row+2)*2 + col*2) == brown){
                    break;
                }
            }
        }
        
        
        
        answer[0] = row+2;
        answer[1] = col+2;
        
        return answer;
    }
}