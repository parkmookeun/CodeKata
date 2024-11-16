import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dnaString = br.readLine();

        int[] essential = new int[4];
        int[] sub = new int[4];
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);

        //{A,C,G,T}
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            essential[i] = Integer.parseInt(st.nextToken());
        }
        //초기화
        for(int i=0; i<p; i++){
            sub[map.get(dnaString.charAt(i))] += 1;
        }
        //초기 값 검사
        boolean isOk = true;
        for(int i=0; i<4; i++){
            if(sub[i] < essential[i]){
                isOk = false;
            }
        }
        if(isOk) answer += 1;
        //이제 앞에서 하나 빼고 뒤에서 하나 더하면서 검사
        int first = 0;
        int last = p-1;
        int end = dnaString.length()-1;
        while(last < end){
            //앞에서 빼주기
            sub[map.get(dnaString.charAt(first))] -= 1;
            //뒤에서 더하기
            sub[map.get(dnaString.charAt(last+1))] += 1;
            //검사
            isOk = true;
            for(int i=0; i<4; i++){
                if(sub[i] < essential[i]){
                    isOk = false;
                }
            }
            if(isOk) answer += 1;
            first++;
            last++;
        }
        System.out.println(answer);
    }

}
