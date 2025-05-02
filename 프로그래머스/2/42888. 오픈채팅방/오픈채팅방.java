import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        //먼저 record의 명령어, 유저ID, 닉네임 분류해서 (유저ID : 닉네임의 형태로 맵에 저장)
        Map<String,String> userMap = new HashMap<>();
        for(int i=0; i<record.length; i++){
            String[] elements = record[i].split(" ");
            if(elements.length < 3) continue;
            userMap.put(elements[1], elements[2]);
        }
        
        // for(String key : userMap.keySet()){
        //     System.out.println(key + ": " + userMap.get(key));
        // }
        
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            String[] elements = record[i].split(" ");
            
            if(elements[0].equals("Enter")){
                answer.add(userMap.get(elements[1]) + "님이 들어왔습니다.");
            }else if(elements[0].equals("Leave")){
                answer.add(userMap.get(elements[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}