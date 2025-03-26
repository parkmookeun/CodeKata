// 핵심 아이디어 : DFS를 이용해서 A부터 U까지 완전 탐색을 해보자!
import java.util.*;
class Solution {
    
    int count = 0;
    boolean keep = true;
    String[] arr = {"A","E","I","O","U"};
    
    public int solution(String word) {
        
        
        // System.out.println(Arrays.toString(arr));
        
        for(int i=0; i<arr.length; i++){
            dfs(arr[i], word, 1);
        }
        
        return count;
    }
    
    void dfs(String current, String word, int depth){
        
        if(!keep) return;
        
        // System.out.println(current);
        count += 1;
        
        if(current.equals(word)){
            keep = false;
            return;
        }
        
        if(depth == 5){
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            dfs(current+arr[i],word,depth+1);
        }
    }
}