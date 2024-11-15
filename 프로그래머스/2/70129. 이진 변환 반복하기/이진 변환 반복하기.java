class Solution {
   public static int[] solution(String s) {
        int[] answer = new int[2];
        int length = 0;
        int count = 0;
        while(!"1".equals(s)){
            length = s.length();
            count = 0;

            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    count += 1;
                }
            }
            s = String.valueOf(length-count);
            s = Integer.toBinaryString(Integer.parseInt(s));
            answer[0] += 1;
            answer[1] += count;
        }

        return answer;
    }
}