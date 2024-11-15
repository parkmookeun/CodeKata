class Solution {
    public String solution(String s) {
        boolean isFirst = true;
        StringBuffer buffer = new StringBuffer();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                isFirst = true;
                buffer.append(s.charAt(i));
                continue;
            }
            
            if(isFirst){
                buffer.append(Character.toUpperCase(s.charAt(i)));
                isFirst = false;
            }else{
                buffer.append(Character.toLowerCase(s.charAt(i)));
            } 
        }
        return new String(buffer);
    }
}