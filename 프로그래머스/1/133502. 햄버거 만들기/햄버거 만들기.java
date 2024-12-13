import java.util.*;
class Solution {
     public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> orderList = new Stack<>();
        int[] popedList = new int[4];
        int[] sequence = {1,3,2,1};
        boolean canMake = false;

        for(int i=0; i<ingredient.length; i++){
            orderList.push(ingredient[i]);

            //orderList의 크기가 4이상이면 햄버거를 만들 수 있는지 검사
            if(orderList.size() >= 4){
                //햄버거 만들 수 있으면
                canMake = true;
                for(int j=0; j<4; j++){
                    popedList[j] = orderList.pop();
                }
                //팝된 요소와 햄버거 순서 비교
                for(int k=0; k<4; k++){
                    if(popedList[k] != sequence[k]){
                        canMake = false;
                        break;
                    }
                }
                if(canMake){
                    answer += 1;
                }else {
                    //다시 넣어주기
                    for(int j=0; j<4; j++){
                        orderList.push(popedList[3-j]);
                    }
                }

                //햄버거 못 만들면
            }
        }

        return answer;
    }
}