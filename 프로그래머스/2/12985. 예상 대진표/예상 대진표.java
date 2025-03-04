//핵심 아이디어: 다음 라운드에 진출하게 되면 다시 1번 부터 N/2까지 다시 배정
//홀수는 항상 + 1인 짝수와 대결을 한다.
//홀수와 짝수가 있을 때, 그 둘이 이기면 갖는 숫자가 동일할때 대결! 

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        
        while(a != b){
            a = a % 2 == 1 ? a+1 : a;
            b = b % 2 == 1 ? b+1 : b;
            
            a /= 2;
            b /= 2;
            
            answer++;
        }

        return answer;
    }
}