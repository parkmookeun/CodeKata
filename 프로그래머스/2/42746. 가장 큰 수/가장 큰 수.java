// 핵심 아이디어 : 문자열 정렬 + 약간의 아이디어
// 문자열 정렬은 앞자리가 큰 순서대로 정렬을 해준다. ex.) 6, 10, 2 -> 6, 2, 10
// 그런데 3, 30, 34, 5, 9 와 같은 케이스에서는 3, 30, 34, 5, 9의 순서로 정렬이된다.
// 여기서 발생하는 문제가 3이 30보다 앞에 있어서 문제가 발생하게 된다.

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numStrings = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            numStrings[i] = numbers[i]+"";
        }
        
        Arrays.sort(numStrings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
            
                int l = o1.length() - o2.length() > 0 ? o2.length() : o1.length();
                
                for(int i=0; i<l; i++){
                    if(o1.charAt(i) != o2.charAt(i)){
                        return o2.charAt(i) - o1.charAt(i);
                    }
                }
                
                if(o1.length() == o2.length()){
                    return 0;
                }else{
                    return (int)(Long.valueOf(o2+o1) - Long.valueOf(o1+o2)); 
                }
            }
        });
        
        // System.out.print(Arrays.toString(numStrings));
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numStrings.length; i++){
            sb.append(numStrings[i]);    
        }
        
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}