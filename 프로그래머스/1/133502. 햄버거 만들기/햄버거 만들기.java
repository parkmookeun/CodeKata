import java.util.*;
class Solution {
     public int solution(int[] ingredient) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> candidate = new Stack<>();
        int[] sequence = new int[]{1,2,3,1};
        int[] willUsed = new int[4];
        boolean[] isUsed = new boolean[ingredient.length];

//        while(idx < ingredient.length){
//            //빵이 아니면 검사 x
//            if(ingredient[idx] != 1){
//                idx++;
//                continue;
//            }
//            //빵이면 검사 시작
//            //현재 빵부터 햄버거가 만들어지면
//            if(candidate.isEmpty() || candidate.peek() != idx){
//                candidate.push(idx);
//            }
//
//            boolean result = checkHamburger(sequence, ingredient, isUsed,willUsed, candidate.peek());
//            //결과가 참이면 개수 + 1 && 전에 1인 곳으로 돌아가기
//            //결과가 거짓이면 그냥 다음으로 넘어가기
//            if(result){
//                answer += 1;
//                candidate.pop();
//                idx = candidate.isEmpty() ? idx + 4 : candidate.peek();
//            }else{
//                idx ++;
//            }
//        }
        int count = 0;

        for(int i=0; i<ingredient.length; i++){
            if(ingredient[i] == 1) count++;

        }
        if(count % 2 == 1){
            count++;
        }
        while(candidate.size() < count / 2){
            if(ingredient[idx] == 1) candidate.push(idx);
            idx++;
        }

        while(!candidate.isEmpty()){

            boolean result = checkHamburger(sequence, ingredient, isUsed,willUsed, candidate.peek());
            //결과가 참이면 개수 + 1 && 전에 1인 곳으로 돌아가기
            //결과가 거짓이면 그냥 다음으로 넘어가기
            if(result){
                answer += 1;
            }
            candidate.pop();

        }

        return answer;
    }

 boolean checkHamburger(int[] sequence, int[] ingredient, boolean[] isUsed, int[] willUsed, int idx){
        //햄버거가 완성되는지 검사
        //1->2->3->1 이되는지, 1부터 검사 시작해서 이미 사용된 재료면 건너뛰기
        //재료를 검사하다가 재료 칸을 벗어나게 되면 중지
        for(int i=0; i<4; i++){
            while((idx+i) < ingredient.length && isUsed[idx+i]){
                idx += 4;
            }

            if((idx+i) >= ingredient.length || sequence[i] != ingredient[idx+i]){

                return false;
            }
            willUsed[i] = idx + i;
        }
        for(int i=0; i<4; i++){
            isUsed[willUsed[i]] = true;
        }

        return true;
    }
}