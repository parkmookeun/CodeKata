/*
  핵심 아이디어: 함수로 표현 + 타입 캐스팅(정밀도 문제)
  
  |-----   -> 1 ~ w 까지 1칸씩 이동하면서, 전 위치에서는 내림을, 이동한 위치에서는 올림을 해서, 그 차이만큼 숫자를 더해나감. 
  |    /| 
  |   / |
  |  /  |
  | /   |
  |/    |
   --------------------------
*/
class Solution {
     public static long solution(int w, int h) {
        long answer = (long)w * h;

        double prev = 0;
        long minus = 0;
        for(int i = 1; i <= w; i++){
            double y = getY(h, w, i);
            int value = (int)Math.ceil(getY(h, w, i)) - (int)Math.floor(prev);
            minus += value;
            prev = y;
        }

        return answer - minus;
    }
    //함수 y = h/w * x
    static double getY(int h, int w, int x){
        return (long)h * x /(double)w;
    }
}