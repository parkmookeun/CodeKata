//핵심 아이디어 : A가 아닌 어떤 문자에서 계속해서 최소 거리를 파악

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // A가 아닌 수의 갯수
        int count = 0;
        
        int minDist = name.length();
        
        // 위 아래 버튼 중 최소의 버튼으로 문자 맞추기
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            
            if(ch != 'A'){
                answer += getValue(ch);
                count++;
            }
        }
        
        //출력
        System.out.println("알파벳 바꾸기 : " + answer);
        
        // 좌 우 버튼 중 최소의 버튼으로 이동하기
        // 하나의 기준이 되는 A가 아닌 문자를 잡고,
        // 0부터 그 문자까지 간 후, 반환해서 왼쪽으로 가는 것이 최소인지
        // 아니면 
        for(int i=0; i<name.length(); i++){
            int currCount = 0;
            
            for(int j=0; j<i; j++){
                if(name.charAt(j) != 'A') currCount++;
            }
            
            int ch = name.charAt(i);
            
            if(ch == 'A') continue;
            
            //A가 아닌 다른 문자라면
            int rightDist = i;
            int leftDist = 0;
            currCount += 1;
            int idx = name.length();
            while(currCount < count){
                idx--;
                if(name.charAt(idx) != 'A'){
                    currCount++;
                }
                leftDist++;
            }
            
            System.out.println("왼쪽거리 : " + leftDist);
            System.out.println("오른쪽거리 : " + rightDist);
            
            int totalDist = (rightDist*2 + leftDist) > (leftDist*2 + rightDist) ?
                (leftDist*2 + rightDist) : (rightDist*2 + leftDist);
            
            minDist = minDist > totalDist ? totalDist : minDist;
        }
        //거리 출력
        System.out.println("거리 출력 : " + minDist);
        
        if(answer == 0) minDist = 0;
        
        return answer+minDist;
    }
    
    // 위 아래 중 어디를 눌러야 더 적게 이동인지 횟수 리턴
    int getValue(char c){
        int value = (c-'A') > Math.abs('Z'- c+1) ? Math.abs('Z' - c+1) : (c - 'A') ;
        return value;
    }
}