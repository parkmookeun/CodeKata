class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        //맞을 수 있는 숫자 개수
        int possibleNum = 0;
        //정답 배열
        int[] answer = new int[2];
        
        //0의 개수 구하기
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                possibleNum += 1;
            }
        }
        
        //일치하는 숫자가 있는지 확인
        int count = 0;
        for(int i=0; i<lottos.length; i++){      
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == 0) break; // 이미 위에서 셌어서. . .
                if(lottos[i] == win_nums[j]){
                    count += 1;
                    break;
                }
            }    
        }
        
        //최고 순위
        answer[0] = possibleNum+count == 0 ? 6 : 7-(possibleNum+count);
        //최저 순위
        answer[1] = count == 0 ? 6 : 7-count;
        
        return answer;
    }
}