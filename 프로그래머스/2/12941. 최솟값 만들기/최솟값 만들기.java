import java.util.Arrays;
// 두 배열을 정렬 후에 하나는 맨 앞부터, 하나는 맨 뒤부터 곱해서 더한다.
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++){
            answer += A[i]*B[A.length-i-1];
        }
        
        return answer;
    }
}