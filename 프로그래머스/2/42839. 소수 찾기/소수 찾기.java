// 핵심 아이디어 : dfs 탐색
import java.util.*;
class Solution {
    int count = 0;
    boolean[] visited;
    Set<Integer> primes;
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        primes = new HashSet<>();
        
        for(int i=0; i<numbers.length(); i++){
            int n = Character.getNumericValue(numbers.charAt(i));
            if(isPrime(n)){
                primes.add(n);
            }
            dfs(String.valueOf(numbers.charAt(i)),i,1,numbers);
        }
        
        answer = primes.size();
        System.out.println(primes);
        return answer;
    }
    
    void dfs(String current, int idx, int depth, String numbers){
        visited[idx] = true;
        
        if(isPrime(toInt(current))){
            primes.add(toInt(current));
        }
        // if(depth == numbers.length()) return;
        
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                // System.out.println(current+numbers.charAt(i));
                dfs(current+numbers.charAt(i), i, depth+1, numbers);
            }
        }
        visited[idx] = false;
    }
    
    
    boolean isPrime(int number){
        
        if(number == 0 || number == 1) return false;
        
        for(int i=2; i<=(int)(Math.sqrt(number)); i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    
    int toInt(String number){
        return Integer.parseInt(number);
    }
}