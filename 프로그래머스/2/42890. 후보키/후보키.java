import java.util.*;

/**
 * 핵심 아이디어 : 릴레이션의 후보키의 개수를 구한다.
 * 후보키는 각 튜플의 유일성을 보장해야한다. -> Set으로 해결
 * 유일성을 보장하고 최소성도 보장해야 한다. -> Set의 요소와 비교를 통해 해결
 *
 * 1. 컬럼갯수 n개에서 1부터 n까지의 조합을 모두 돌린다. 예를 들어 n = 3 이면 -> 3C1, 3C2, 3C3
 * 2. 조합의 경우의 수를 리스트로 바꾼다.  3C1 => [0],[1],[2]
 * 3. relation에서 해당 컬럼의 값을 서로 비교하면서 중복되는 값이 있는지 판단
 * 4. 중복되는 값이 있으면 해당 컬럼은 넘어간다.
 * 5. 중복되는 값이 없으면 예외처리를 하고 예외처리 통과 시, Set에 추가
 *
 * 예외 처리 => 유일성을 보장하는데, 최소성은 보장하지 않는 경우 
 *  -> [1,2]가 최소성인데,, [1,2,3]이 추가되는 경우 [1,2,3]을 삭제한다.
 * + 예외 처리 추가) 예를들어 [2,3]이 후보키인데,,, [1,2,3]을 만난 경우, 
 *   [1,3]이 후보키인데,,,, [1,2,3]을 만난 경우
 */
class Solution {

    public static int solution(String[][] relation) {
        //컬럼 개수
        int columnCount = relation[0].length;
        
        //컬럼 개수만큼 0부터 n-1까지 있는 배열 생성
        int[] column = new int[columnCount];
        for (int i = 0; i < columnCount; i++) {
            column[i] = i;
        }
        
        //후보키가 될 인덱스들을 저장할 Set
        Set<String> indexSet = new HashSet<>();

        //컬럼 갯수만큼 반복
        for (int i = 1; i <= columnCount; i++) {
            //column배열에서 i개만큼 뽑기 -> 조합 만들기
            List<List<Integer>> lists = combineRecursive(column, i);
            // i개로 만든 조합의 경우의 수 중에서
            for (List<Integer> list : lists) {
                // [1,2,3] -> "123"으로 만들어주는 함수
                String idxString = getStringFromIndex(list);
                // 유일성 검사
                boolean isUnique = checkUniqueConstraint(relation, list);
                // 유일성 검사 실패 시, 다음 경우의 수로 넘어감
                if(!isUnique) continue;
                //최소성 검사
                boolean isMinimum = true;
                for (String str : indexSet) {
                    isMinimum = checkMinimumConstraint(idxString, str);
                    if(!checkMinimumConstraint(idxString, str)){
                        isMinimum = false;
                        break;
                    }
                }
                //최소성을 만족하면 Set에 해당 경우의 수 저장
                if(isMinimum) indexSet.add(idxString);
            }

        }
        return indexSet.size();
    }

    //단순히 Set의 요소를 하나하나씩 분리해서, 현재 경우의 수에 전부 포함되어있는지 확인
    private static boolean checkMinimumConstraint(String idxString, String setValue) {
        // str은 set에 있는 값
        for (int i = 0; i < setValue.length(); i++) {
            if(!idxString.contains(setValue.charAt(i)+"")) return true;
        }
        return false;
    }

    //만약 값이 중복되면 true, 중복안되면 false
    private static boolean checkUniqueConstraint(String[][] relation, List<Integer> list) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            boolean isAddable = set.add(getStringFromRelation(list, relation, i));
            if(!isAddable){
                return false;
            }
        }

        return true;
    }

    // 방법 1: 재귀적 구현
    public static List<List<Integer>> combineRecursive(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, int k,
                                  List<Integer> current, List<List<Integer>> result) {
        // 조합이 완성된 경우
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 남은 원소들을 하나씩 선택
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, i + 1, k, current, result);
            current.remove(current.size() - 1); // 백트래킹
        }
    }

    // 리스트의 요소를 문자열로 반환 (인덱스 구하기)
    private static String getStringFromIndex(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    // 리스트의 요소를 문자열로 반환(인덱스에 맞는 값을 문자열로 구하기)
    private static String getStringFromRelation(List<Integer> list, String[][] relation, int idx) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(relation[idx][i]);
        }
        return sb.toString();
    }
}