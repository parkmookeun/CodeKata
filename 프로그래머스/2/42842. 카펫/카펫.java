class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int row = 0;
        int column = 0;
        for(int i=1; i<=(int)(Math.sqrt(yellow)); i++){
            if(yellow % i == 0){
                row = yellow / i;
                column = i;
                System.out.println(row+","+column);
                if(((column+2)*2 + row*2) == brown){
                    answer[0] = row+2;
                    answer[1] = column+2;
                    break;
                }
            }
        }
       
        
        return answer;
    }
}