// 핵심 아이디어 : 캐시는 최대 30개까지이고, 캐시는 한번 조회된 데이터를 빠르게 가져오는 특성이 있다.
// Set과 Queue를 사용 + 주의사항) 대소문자 구분 x ( LRU 알고리즘 -> 오래사용되지 않은 것부터 삭제)

import java.util.Set;
import java.util.HashSet;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        // notExist -> 캐싱이 됐으면 false / 안됐으면 true
        boolean notExist = false;
        
        // cache된 정보를 저장할 Set
        Set<String> cache = new HashSet<>();
        
        // 현재 cache된 정보를 추가/삭제할 큐
        Deque<String> cacheQueue = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){
            
            if(cacheSize == 0){
                answer += 5;
                continue;
            }
            
            if(cache.size() < cacheSize){
                notExist = cache.add(cities[i].toLowerCase());
                
                if(!notExist){
                    cacheQueue.remove(cities[i].toLowerCase());
                    cacheQueue.add(cities[i].toLowerCase());
                    answer += 1;
                }else{
                    cacheQueue.add(cities[i].toLowerCase());
                    answer += 5;
                }
                continue;
            }
            
            //캐시 사이즈가 다 찬 경우 -> LRU
            notExist = cache.add(cities[i].toLowerCase());
            
            //캐시큐에 해당 문자열이 이미 있는 경우
            if(!notExist){
                cacheQueue.remove(cities[i].toLowerCase());
                cacheQueue.add(cities[i].toLowerCase());
                answer += 1;
            }else{
                cache.remove(cacheQueue.poll());
                cacheQueue.add(cities[i].toLowerCase());
                answer += 5;
            }
        }
        
        return answer;
    }
}