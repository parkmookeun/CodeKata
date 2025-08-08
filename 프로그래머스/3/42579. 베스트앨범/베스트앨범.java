
import java.util.*;

/**
 * 핵심 아이디어 :
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 *
 * 1. 먼저 장르별 재생 수를 맵에 저장하면서, 그 idx를 리스트에 저장한다.
 * 2. 그 중 재생 수가 많은 장르부터,,,
 */

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Pair> genreSortedList = new ArrayList<>();

        for (String key : genreMap.keySet()) {
            genreSortedList.add(new Pair(key, genreMap.get(key)));
        }

        genreSortedList.sort(null);

//        for (Pair pair : genreSortedList) {
//            System.out.println(pair);
//        }

        for (Pair genreSortedDesc : genreSortedList) {
            List<int []> countIdxList = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(genreSortedDesc.key)){
                    countIdxList.add(new int[]{plays[i], i});
                }
            }

            countIdxList.sort((o1, o2) -> (o1[0] - o2[0]) * (-1));
//            for (int[] ints : countIdxList) {
//                System.out.println(ints[1] + ": " + ints[0]);
//            }
            int limit = Math.min(countIdxList.size(), 2);
            for (int i = 0; i < limit; i++) {
                answer.add(countIdxList.get(i)[1]);
            }
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println("solution = " + solution);
    }
}

class Pair implements Comparable<Pair> {
    String key;
    Integer value;

    public Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair other) {
        return this.value.compareTo(other.value) * (-1);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}