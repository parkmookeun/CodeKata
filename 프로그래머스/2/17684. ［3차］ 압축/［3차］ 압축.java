// 핵심 아이디어 : 문자열 인덱스 0부터, 문자열의 길이 만큼 반복하면서 사전에 이어붙인 문자열이 없다면 추가
// 있다면 다음으로 넘어가면서 답을 찾는다.
import java.util.*;

class Solution {
     public static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();

        Map<String,Integer> map = new HashMap<String,Integer>();

        //초기화
        for(int i=0; i<26; i++){
            map.put(String.valueOf((char)('A'+i)),i+1);
        }

        int idx = 0;
        int length = msg.length();

        while(idx < length){
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(idx));
            int temp;

            // map에 해당 키값이 없을 때까지
            do{
                temp = map.get(sb.toString());
                idx++;

                if(idx == length){
                    break;
                }

                sb.append(msg.charAt(idx));

            }while(map.get(sb.toString()) != null);


            answer.add(temp);

            map.put(sb.toString(), map.getOrDefault(sb.toString(),map.size()+1));
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}