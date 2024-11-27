import java.util.HashMap;
class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        //영어로된 숫자를 담을 문자열
        String digit = "";
        
        //영단어와 숫자를 매핑할 해시맵
        HashMap<String, Integer> englishWords = new HashMap<>();
        
        //숫자를 담을 스트링 버퍼
        StringBuffer bf1 = new StringBuffer();
        //영문자를 담을 스트링 버퍼
        StringBuffer bf2 = new StringBuffer();
        
        //해시 맵에 숫자와 영어 담기
        englishWords.put("one",1);englishWords.put("two",2);
        englishWords.put("three",3);englishWords.put("four",4);
        englishWords.put("five",5);englishWords.put("six",6);
        englishWords.put("seven",7);englishWords.put("eight",8);
        englishWords.put("nine",9);englishWords.put("zero",0);
        
        
        
        //for문을 이용해서
        for(int i=0; i<s.length(); i++){
            //현재 문자
            char c = s.charAt(i);
            //만약 숫자면 bf1에 담기
            if(Character.isDigit(c)){
                bf1.append(c);
            }//만약 영문자면 bf2에 담기
            else{
                bf2.append(c);
                digit = new String(bf2);
                //digit을 문자열로 변환해서 해시 맵에 매칭되는 값이 있는지 확인
                for (String key : englishWords.keySet()){
                    //매칭되는 값이 있으면 bf1에 담고, bf2 비우기
                    if (key.equals(digit)){
                        bf1.append(englishWords.get(key));
                        bf2.delete(0,bf2.length());
                    }
                }
            }
        }
        
        //bf1에 담긴 숫자를 파싱해서 answer에 넣기
        answer = Integer.parseInt(new String(bf1));
        return answer;
    }
}