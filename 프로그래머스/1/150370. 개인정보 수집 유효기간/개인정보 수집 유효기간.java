import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        //먼저 약관의 내용을 map에 저장한다. A -> 6 이런식
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].charAt(0), Integer.parseInt(terms[i].substring(2)));
        }
        //오늘 날짜를 분해한다(년,월,일)
        int todayYear = Integer.parseInt(today.substring(0,4));
        int todayMonth = Integer.parseInt(today.substring(5,7));
        int todayDay = Integer.parseInt(today.substring(8));
        // System.out.println(todayYear+"/"+todayMonth+"/"+todayDay);
        //그리고 개인정보들을 검사한다.
        int year = 0;
        int month = 0;
        int day = 0;
        
        //파기할 내용 검사
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            year = Integer.parseInt(privacies[i].substring(0,4));
            month = Integer.parseInt(privacies[i].substring(5,7));
            day = Integer.parseInt(privacies[i].substring(8,10));
            
            //약관내용확인
            String term = privacies[i].substring(11);
            month += map.get(term.charAt(0));
         
            year += month / 12;
            month %= 12;
            if(month == 0){
                month = 12;
                year -= 1;
            }
            
            // System.out.println(year+"/"+month+"/"+day);
            //날짜 비교
            if(todayYear > year){
                answer.add(i+1);
            }else if(todayYear == year && todayMonth > month){
                answer.add(i+1);
            }else if(todayYear == year && todayMonth == month && todayDay >= day){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}