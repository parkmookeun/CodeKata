// 핵심 아이디어 : 길이가 작은 집합부터 튜플에 추가
// 길이가 하나씩 늘어나면서 해당 집합의 나머지 수를 튜플에 추가
// 길이가 작은 것부터 어떻게 튜플에 추가를 할까??? -> 
import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new LinkedHashSet<>();
        
        // 문자열에서 중괄호, 공백 제거하고 배열 단위로 분리
        s = s.replace("{{", "{").replace("}}", "}");
        String[] arrayStrings = s.substring(1, s.length() - 1).split("\\},\\{");
        
        // 각 배열 문자열을 실제 정수 배열로 변환
        List<List<Integer>> arrays = new ArrayList<>();
        for (String arrayStr : arrayStrings) {
            arrayStr = arrayStr.replace("{", "").replace("}", "");
            if (arrayStr.isEmpty()) {
                arrays.add(new ArrayList<>());
                continue;
            }
            
            String[] elements = arrayStr.split(",");
            List<Integer> array = new ArrayList<>();
            for (String element : elements) {
                array.add(Integer.parseInt(element));
            }
            arrays.add(array);
        }
        
        // 배열 길이에 따라 정렬
        arrays.sort(Comparator.comparingInt(List::size));
        
        for(int i=0; i<arrays.size(); i++){
            for(int j=0; j<arrays.get(i).size(); j++)
            {
                set.add(arrays.get(i).get(j));        
            }        
        }
        
        return set.stream().mapToInt(Integer::intValue).toArray();
        
    }
}