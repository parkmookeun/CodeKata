import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> list = new ArrayList<>(Arrays.asList(s.split("")));

        for(int i=0; i<s.length(); i++){
            answer += checkList(list);
            String remove = list.remove(0);
            list.add(remove);
        }
        return answer;
    }

    private int checkList(List<String> list) {
        Stack<String> stack = new Stack<>();
        Map<String,String> map = new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        
        
        int idx = 0;
        while(idx < list.size()){
            String value = list.get(idx);
            if(value.equals("{") || value.equals("[") || value.equals("(")){
                stack.push(value);
            }else{
                if (stack.isEmpty()){
                    return 0;
                }
                String peek = stack.peek();
                if(!map.get(peek).equals(value)){
                    return 0;
                }
                stack.pop();
            }
            idx++;
        }
        if(!stack.isEmpty()){
            return 0;
        }
        return 1;
    }
}