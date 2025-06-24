// 핵심 아이디어 : 차량별 주차 요금을 계산
// 어떤 자료구조를 사용할 것인가...
// records의 정보를 저장할 자료구조... -> Map -> 차량번호, 시간 -> 존재하면 IN인 거고, OUT이면 계산하고 시간 null로
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        //Map 초기화
        Map<String, String> carMap = new HashMap<>();
        //차량의 요금을 담을 배열 및 시간을 담을 배열 초기화
        int[] carTimes = new int[10000];
        
        //records의 정보를 하나씩 계산
        for(int i=0; i<records.length; i++){
            String[] info = records[i].split(" ");
            
            //만약 정보가 map에 없으면
            if(carMap.get(info[1]) == null){
                carMap.put(info[1], info[0]);
                continue;
            }
            //만약 정보가 있으면 요금 계산
            // System.out.println(info[0].substring(0,2));
            // System.out.println(info[0].substring(3));
            int endTime = Integer.parseInt(info[0].substring(0,2))*60 + 
                Integer.parseInt(info[0].substring(3));
            
            String start = carMap.get(info[1]);
            int startTime = Integer.parseInt(start.substring(0,2))*60 + 
                Integer.parseInt(start.substring(3));
            
            // System.out.println(endTime - startTime);
            carMap.put(info[1], null);
            
            carTimes[Integer.parseInt(info[1])] += (endTime - startTime);
        }
        
        //한번 더 검사해서 출차되지 않는 경우도 조사
        int endTime = 23*60 + 59;
        for(String key : carMap.keySet()){
            String carTime = carMap.get(key);
            
            if(carTime != null){
                int startTime = Integer.parseInt(carTime.substring(0,2))*60 + 
                Integer.parseInt(carTime.substring(3));
                
                carTimes[Integer.parseInt(key)] += (endTime - startTime);
            }
        }
        
        //자 이제 주차 요금 계산
        List<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0; i<carTimes.length; i++){
            if(carTimes[i] == 0) continue;
            
            int fee = (carTimes[i] > fees[0]) ? fees[1] + 
                (int)(Math.ceil((carTimes[i] - fees[0]) / (double) fees[2]) * fees[3]) : fees[1];
            
            answer.add(fee);
        }
        
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}