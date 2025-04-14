//핵심 아이디어: 두 문자열을 2문자씩 쌍으로 만든 배열을 만든다.
// 만든 배열을 각각 교집합과 합집합으로 만들어서 자카드 유사도를 구한다.
//교집합 및 합집합 -> 맵을 사용
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> strList1 = new ArrayList<>();
        ArrayList<String> strList2 = new ArrayList<>();
        
        //두 문자열을 2문자씩 쌍으로 만든 배열
        for(int i=0; i<str1.length()-1; i++){
            char firstLetter = str1.charAt(i);    
            char secondLetter = str1.charAt(i+1);
            
            if(!Character.isAlphabetic(firstLetter) || !Character.isAlphabetic(secondLetter)){
                continue;
            }
            String letters = String.valueOf(Character.toLowerCase(firstLetter)) + String.valueOf(Character.toLowerCase(secondLetter));
            
            strList1.add(letters);
        }
        
        for(int i=0; i<str2.length()-1; i++){
            char firstLetter = str2.charAt(i);    
            char secondLetter = str2.charAt(i+1);
            
            if(!Character.isAlphabetic(firstLetter) || !Character.isAlphabetic(secondLetter)){
                continue;
            }
            String letters = String.valueOf(Character.toLowerCase(firstLetter)) + String.valueOf(Character.toLowerCase(secondLetter));
            
            strList2.add(letters);
        }
        
        // System.out.println(strList1.toString());
        // System.out.println(strList2.toString());
        
        //교집합과 합집합 개수 구하기
        Map<String,Integer> str1Map = new HashMap<>();
        for(int i=0; i<strList1.size(); i++){
            String key = strList1.get(i);
            str1Map.put(key, str1Map.getOrDefault(key,0)+1);
        }
        
        Map<String,Integer> str2Map = new HashMap<>();
        for(int i=0; i<strList2.size(); i++){
            String key = strList2.get(i);
            str2Map.put(key, str2Map.getOrDefault(key,0)+1);
        }
        
        //공집합일 때는 1
        if(strList1.size() == 0 && strList2.size() == 0){
            return 65536;
        }
           
        //교집합 수 구하기
        int interSection = 0;
        for(String key : str1Map.keySet()){
            interSection += Math.min(str1Map.get(key), str2Map.getOrDefault(key,0));
        }
        
        //합집합 수 구하기
        int union = 0;
        Set<String> unionSet = new HashSet<>();
        for(String key : str1Map.keySet()){
            unionSet.add(key);
            union += Math.max(str1Map.get(key), str2Map.getOrDefault(key,0));
        }
        //
        for(String key : str2Map.keySet()){
            if(!unionSet.contains(key)){
                union += Math.max(str2Map.get(key), str1Map.getOrDefault(key,0));
            }
        }
        
        System.out.println(interSection);
        System.out.println(union);
        
        answer = (int)((double) interSection / union * 65536);   
        return answer;
    }
}