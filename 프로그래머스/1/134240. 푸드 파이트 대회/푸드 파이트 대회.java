class Solution {
    public String solution(int[] food) {
        
        // 물을 기준으로 왼쪽에 더할 숫자
        StringBuffer bf1 = new StringBuffer();
        //물을 기준으로 오른쪽에 더할 숫자
        StringBuffer bf2 = new StringBuffer();
        
        //음식의 개수대로 배치한다.
        for(int i=1; i<food.length; i++){
            //음식 개수 반으로 나누기
            int count = food[i] / 2;
            
            for(int j=0; j<count; j++){
                bf1.append(i);
                bf2.append(i);
            }
        }
        
        //왼쪽 + 물 + 오른쪽
        bf1.append(0).append(bf2.reverse());
        return new String(bf1);
    }
}