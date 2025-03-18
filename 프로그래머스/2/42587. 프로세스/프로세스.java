// 핵심 아이디어 :  큐 + 현재 빠져 나가야할 중요도가 무엇인지 체크하는 로직
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        
        Queue<Node> queue = new LinkedList<>();
        int[] outSequence = priorities.clone();
                
        Arrays.sort(outSequence);
        
        int seqIdx = outSequence.length-1;
        int count = 0;
        
        for(int i=0; i<priorities.length; i++){
            queue.add(new Node(priorities[i],i));
        }
        
        //하나씩 빼면서 검사
        while(true){
            
            Node node = queue.poll();
            
            if(node.value == outSequence[seqIdx]){
                count++;
                seqIdx--;
                if(node.idx == location){
                    answer = count;
                    break;
                }
            } 
            else queue.add(node);
        }
        
        return answer;
    }
}

class Node{
    int value;
    int idx;
    
    public Node(int value, int idx){
        this.value = value;
        this.idx = idx;
    }
}