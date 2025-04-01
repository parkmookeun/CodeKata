
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String stmt = sc.next();

        int total = 0;
        boolean isMinus = false;
        StringBuilder num = new StringBuilder();
        for(int i=0; i<stmt.length(); i++){
            char ch = stmt.charAt(i);

            if(ch >= '0' && ch <= '9'){
                num.append(ch);
            }else {
                //연산자인 경우
                if(ch == '-'){
                    if(isMinus){
                        total -= Integer.parseInt(num.toString());
                        num = new StringBuilder();
                    }else{
                        total += Integer.parseInt(num.toString());
                    }
                    isMinus = true;
                    num = new StringBuilder();
                }else{
                    if(isMinus){
                        total -= Integer.parseInt(num.toString());
                        num = new StringBuilder();
                    }else{
                        total += Integer.parseInt(num.toString());
                    }
                    num = new StringBuilder();
                }
            }

            if(i == (stmt.length()-1)){
                if(isMinus){
                    total -= Integer.parseInt(num.toString());
                }else{
                    total += Integer.parseInt(num.toString());
                }
            }
        }
        System.out.println(total);
    }
}
