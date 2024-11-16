import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       String[] str = br.readLine().split(" ");
       int[] arr = new int[n];
       for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(str[i]);
       }
       int[] answer = new int[n];
       Stack<Integer> stack = new Stack<>();
       stack.push(0);
       for(int i=1; i<arr.length; i++){
           while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
               answer[stack.pop()] = arr[i];
           }
           stack.push(i);
       }
       while(!stack.isEmpty()){
           answer[stack.pop()] = -1;
       }
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       for(int i=0; i<n; i++){
           bw.write(answer[i]+" ");
       }
       bw.flush();
    }
}