import java.util.*;

class Solution {
  public int[] solution(String[] id_list, String[] report, int k) {
        //정답 배열
        int[] answer = new int[id_list.length];
        //신고자의 인덱스 저장 맵
        Map<String,Integer> reporter = new HashMap<>();
        //report배열의 결과를 담을 신고당한사람 별 신고횟수 맵
        Map<String,Integer> countPerReported = new HashMap<>();

        //reporter 초기화
        for(int i=0; i<id_list.length; i++){
            reporter.put(id_list[i],i);
        }
        for (String s : reporter.keySet()) {
            System.out.print(s+ reporter.get(s)+", ");
        }
        //countPerReported 초기화(key: 신고당한 사람, value: 신고당한 횟수)
        //동일한 신고자에 대한 중복 처리
        Set<String> reportSet = new HashSet<>();
        Collections.addAll(reportSet, report);
        report = reportSet.toArray(new String[0]);

        int idx = 0;
        String name = "";
        for (String string : report) {
            idx = string.indexOf(' ');
            name = string.substring(idx + 1);
            if (countPerReported.get(name) == null) {
                countPerReported.put(name, 1);
            } else {
                countPerReported.put(name, countPerReported.get(name) + 1);
            }
        }

        //마지막 체크
        String name1 = "";
        String name2 = "";
        for(int i=0; i<report.length; i++){
            idx = report[i].indexOf(' ');
            name1 = report[i].substring(0,idx);
            name2 = report[i].substring(idx + 1);

            if(countPerReported.get(name2) >= k){
                answer[reporter.get(name1)] += 1;
            }
        }

        for (String s : countPerReported.keySet()) {
            System.out.print(s+ countPerReported.get(s)+", ");
        }

        return answer;
    }
}