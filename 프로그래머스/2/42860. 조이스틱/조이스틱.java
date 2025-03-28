//핵심 아이디어 : A가 아닌 어떤 문자에서 계속해서 최소 거리를 파악
// 문자변환 시의 최솟값 + 이동할 때의 최솟값
class Solution {
    public int solution(String name) {
        int answer = 0;
        
        // A가 아닌 수의 갯수
        int count = 0;
        
        //다녀야 하는 거리
        int minDist = name.length();
        
        // 위 아래 버튼 중 최소의 버튼으로 문자 맞추기 -> 문자 변환시 최솟값 구하기
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            
            if(ch != 'A'){
                answer += getValue(ch);
                count++;
            }
        }
        
        // 좌 우 버튼 중 최소의 버튼으로 이동하기
        // 하나의 기준이 되는 A가 아닌 문자를 잡고,
        // 0부터 오른쪽으로 그 문자까지 간 후, 반환해서 왼쪽으로 가는 것이 최소인지
        // 아니면 왼쪽으로 그 문자까지 간 후, 반환해서 오른쪽으로 가는 것이 최소인지 판단
        for(int i=0; i<name.length(); i++){
            //현재 A가 아닌 수의 갯수
            int currCount = 0;
            
            // i번째 전까지 A가 아닌 수가 몇번 나왔는지 수 세기
            for(int j=0; j<i; j++){
                if(name.charAt(j) != 'A') currCount++;
            }
            
            //현재 문자
            int ch = name.charAt(i);
            
            //A면 넘어가기
            if(ch == 'A') continue;
            
            //A가 아닌 다른 문자라면
            currCount += 1;
            
            //오른쪽 거리와 왼쪽 거리 계산
            int rightDist = i;
            int leftDist = 0;
            
            int idx = name.length();
            
            while(currCount < count){
                idx--;
                if(name.charAt(idx) != 'A'){
                    currCount++;
                }
                leftDist++;
            }
            
            //(왼쪽거리 * 2 + 오른쪽 거리)와 (오른쪽거리*2 + 왼쪽거리) 중 작은 값 찾기 
            int totalDist = (rightDist*2 + leftDist) > (leftDist*2 + rightDist) ?
                (leftDist*2 + rightDist) : (rightDist*2 + leftDist);
            
            //거리 중 최솟값을 계속 minDist에 갱신
            minDist = minDist > totalDist ? totalDist : minDist;
        }
        
        //만약 모든 문자가 0으로 이루어져있다면,,, minDist는 0
        if(answer == 0) minDist = 0;
        
        return answer+minDist;
    }
    
    // 위 아래 중 어디를 눌러야 더 적게 이동인지 횟수 리턴
    int getValue(char c){
        int value = (c-'A') > Math.abs('Z'- c+1) ? Math.abs('Z' - c+1) : (c - 'A') ;
        return value;
    }
}