class Solution {
    public String solution(int[] food) {
        StringBuffer bf1 = new StringBuffer();
        StringBuffer bf2 = new StringBuffer();
        for(int i=1; i<food.length; i++){
            int count = food[i] / 2;
            for(int j=0; j<count; j++){
                bf1.append(i);
                bf2.append(i);
            }
        }
        bf1.append(0).append(bf2.reverse());
        return new String(bf1);
    }
}