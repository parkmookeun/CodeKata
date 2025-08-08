
import java.util.*;

/**
 * 핵심 아이디어 :
 *
 * 1. 먼저 보석 종류 파악하기 -> Set
 *
 */
class Solution {

    public static int[] solution(String[] gems){

        Set<String> gemSet = new HashSet<>(List.of(gems));
        int gemType = gemSet.size();

        Map<String, Integer> gemCount = new HashMap<>();
        //종류가 1개인 경우
        if(gemType == 1){
            return new int[]{1,1};
        }
        //종류가 중복이 없는 경우
        if (gemType == gems.length) {
            return new int[]{1, gems.length};
        }

        int left = 0;
        int right = 1;
        gemCount.put(gems[left], gemCount.getOrDefault(gems[left],0) + 1);
        gemCount.put(gems[right], gemCount.getOrDefault(gems[right],0) + 1);

        List<int []> answer = new ArrayList<>();
        while (left <= right && right < gems.length) {

            if(isAllIncluded(gemCount, gemType)){
                answer.add(new int[]{left + 1, right + 1});
                gemCount.put(gems[left], gemCount.getOrDefault(gems[left],0) - 1);
                if(gemCount.get(gems[left]) == 0) gemCount.remove(gems[left]);
                left++;
            }else{
                right++;
                if(right < gems.length){
                    gemCount.put(gems[right], gemCount.getOrDefault(gems[right],0) + 1);
                }
            }
        }

        answer.sort((o1, o2) -> {
            if((o1[1] - o1[0]) == (o2[1] - o2[0])) return o1[0] - o2[0];
            else return (o1[1] - o1[0]) - (o2[1] - o2[0]);
        });

        return answer.get(0);
    }

    public static boolean isAllIncluded(Map<String,Integer> map, int count){
        return map.size() == count;
    }
}