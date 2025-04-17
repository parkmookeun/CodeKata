//핵심 아이디어: 조합(콤비네이션)으로 풀어보기
import java.util.*;
class Solution {
    
    static Map<String,Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        boolean[] visited;
        
        //먼저 문자열 배열의 각 요소를 정렬 ->  ex.) WXA => AWX
        for(int i=0; i<orders.length; i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = new String(charArr);
        }

        for(int i=0; i<course.length; i++){
            map = new HashMap<>();
            //n개중 뽑아낼 수 k개
            int count = course[i];
           //orders의 문자열 하나씩 검사
           for(int j=0; j<orders.length; j++){
            // 맵에 정보 AB : 1 개, AC : 4개 등등...
            for(int k=0; k<orders[j].length(); k++){
                combination(orders[j], ""+orders[j].charAt(k), k, 1, count);
                }
            }
            //맵 중에서 가장 개수가 많은 코스요리 추가
            int maxValue = 0;
            for(String key : map.keySet()){
                if(maxValue < map.get(key) && map.get(key) >= 2){
                    maxValue = map.get(key);
                }
            }
            
            for(String key : map.keySet()){
                if(map.get(key) == maxValue){
                    answer.add(key);
                }
            }
            
        }
        String[] answerArr = answer.toArray(new String[0]);
        Arrays.sort(answerArr);
        return answerArr;
    }
    
    //조합 개수 구해서 맵에 넣기
    void combination(String str, String temp, int idx, int depth, int maxDepth){
        
        if(idx == str.length()) return;
        
        
        
        //종료 조건        
        if(depth == maxDepth){
            map.put(temp, map.getOrDefault(temp,0)+1);
            return;
        }
        
        for(int i=idx+1; i<str.length(); i++){
            //if(!visited[i]){ 
                combination(str, temp+str.charAt(i),i, depth+1, maxDepth);
           // }
            //visited[i] = false;
        }
    }
}