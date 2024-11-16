import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int n =sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for(int i=1; i<=n; i++){
            if(arr[idx] != i){
                stack.push(i);
                sb.append("+\n");
                continue;
            }
            stack.push(i);
            sb.append("+\n");
            while(!stack.isEmpty() && stack.peek() == arr[idx]){
                stack.pop();
                sb.append("-\n");
                idx++;
            }
        }
        if(idx != n){
            System.out.println("NO");
        }else{
            System.out.println(new String(sb));
            
        }
    }
}