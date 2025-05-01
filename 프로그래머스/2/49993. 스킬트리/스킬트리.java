import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Set<Character> precedingSkill = new HashSet<>();
        for(int i=0; i<skill.length(); i++){
            precedingSkill.add(skill.charAt(i));
        }
        
        for(int i=0; i<skill_trees.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<skill_trees[i].length(); j++){
                if(precedingSkill.contains(skill_trees[i].charAt(j))){
                    sb.append(skill_trees[i].charAt(j));
                }
            }
            
            String temp = sb.toString();
            boolean flag = true;
            for(int k=0; k<temp.length(); k++){
                if(temp.charAt(k) != skill.charAt(k)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}