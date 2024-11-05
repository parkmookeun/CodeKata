class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        //문자열 길이 만큼 반복
        for(int i=0; i<s.length(); i++){
            //스킵할 문자열에 포함되어 있으면 건너뛰고, 아니면 count + 1
            char ch = s.charAt(i);
             
            int count = 0;
            while(count < index){
                ch = (char)(ch+1);
                if((int)ch > 122){
                        ch = (char)(ch-26);
                    }
                //스킵할 문자이면
                if(!skip.contains(String.valueOf(ch))){ 
                    if((int)ch > 122){
                        ch = (char)(ch-26);
                    }
                    count += 1;
                }  
            }
            System.out.print(ch);
            answer += ch;
        }
        return answer;
    }
}