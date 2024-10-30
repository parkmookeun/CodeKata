class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int possibleNum = 0;
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
                if(lottos[i] == 0) break;
                if(lottos[i] == win_nums[j]){
                    count += 1;
                    break;
                }
            }    
        }
        //count 와 possibleNum을 합쳐서 계산
        answer[0] = possibleNum+count == 0 ? 6 : 7-(possibleNum+count);
        answer[1] = count == 0 ? 6 : 7-count;
        
        return answer;
    }
}