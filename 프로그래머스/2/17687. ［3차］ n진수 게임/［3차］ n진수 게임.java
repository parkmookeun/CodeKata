class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();

        int number = 0;
        int length = 0;
        while(length < m*t){
            String str = convertToRadix(number,n);
            sb.append(str);
            length += str.length();
            number++;
        }

        String arr = sb.toString();
        sb = new StringBuilder();
        for(int i=0; i<t; i++){
            sb.append(arr.charAt(m*i+p-1));
        }

        return sb.toString();
    }
    String convertToRadix(int number, int radix){
        String value = "";

        if(number == 0) value = "0";

        while(number > 0){
            int rest = number % radix;

            if(rest >= 10){
                char ch = (char)('A' + rest % 10);
                value = String.valueOf(ch) + value;
            }else{
                value = (number % radix) + value;
            }

            number /= radix;
        }

        return value;
    }
}