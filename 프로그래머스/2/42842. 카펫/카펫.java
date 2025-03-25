// yellow의 가로 세로가 될 수 있는 경우의 수를 구함
// 각 경우마다 검사해서 brown 개수가 되면 답이니까 break
class Solution {
    public int[] solution(int brown, int yellow) {
        //정답 배열
        int[] answer = new int[2];
        
        // 가로, 세로
        int row = 0;
        int col = 0;
        
        // 가로 길이 >= 세로 길이 이므로
        for(int i=1; i<= (int)(Math.sqrt(yellow)); i++){
            if(yellow % i == 0){
                col = i;
                row = yellow / col;        
                
                // yellow를 덮는 타일이 brown일때
                if(((row+2)*2 + col*2) == brown){
                    break;
                }
            }
        }
        
        
        // 정답 추출
        answer[0] = row+2;
        answer[1] = col+2;
        
        return answer;
    }
}