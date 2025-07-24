import java.util.ArrayList;
import java.util.List;

/**
 * 핵심 아이디어: 구현 문제
 * 우선 연산자 우선순위가 나올 수 있는 경우의 수가 6가지이다. 3!
 * 6가지의 경우의 수를 모두 돌려보면서 최대의 값을 구함
 *
 * 1. 우선 숫자와 연산자를 구분해서 리스트로 저장
 * 2. 리스트의 요소를 우선순위가 높은 연산자로 계산을 해준다. -> 그 후, 리스트 반환
 *    ex) 리스트에서 +인 요소부터 계산 후, 안된 요소를 리스트로 반환 -> 그 다음 연산자로 계산 ,,,, 
   3. 이렇게 3번 반복하면 리스트에 숫자 하나만 남음
   4. 그 숫자의 절댓값을 최댓값과 비교하면서 갱신
 **/
class Solution {
     public static long solution(String expression) {
        //
        long answer = 0L;
        //연산자 우선순위 케이스 6개
        String[] operators = {
                "+-*",
                "+*-",
                "-*+",
                "-+*",
                "*-+",
                "*+-"
        };
        //숫자와 연산자들을 분리
        List<String> separatedList = separateExpression(expression);

        //연산자 우선순위를 가지고 계산하기
        for (int i = 0; i < operators.length; i++) {
            answer = Math.max
                (answer, Math.abs(calculateMaxValue(new ArrayList<>(separatedList), operators[i])));
        }

        return answer;
    }
    // 우선순위 순서대로 계산한 값 반환
    private static long calculateMaxValue(List<String> separatedList, String operator) {

        //첫번째 우선순위로 계산
        List<String> firstOperatedList = calculateWithOperator(separatedList, String.valueOf(operator.charAt(0)));
        //두번째 우선순위로 계산
        List<String> secondOperatedList = calculateWithOperator(firstOperatedList, String.valueOf(operator.charAt(1)));
        //세번째 우선순위로 계산
        List<String> thirdOperatedList = calculateWithOperator(secondOperatedList, String.valueOf(operator.charAt(2)));

        //마지막에 1개남은 값 반환
        return Long.parseLong(thirdOperatedList.get(0));
    }
    
    //해당 우선순위로 계산 -> 리스트에서 연산자를 만나면 idx 전,후 값을 연산자로 계산 후, remove
    private static List<String> calculateWithOperator(List<String> separatedList, String op) {
        for (int i = 0; i < separatedList.size(); i++) {
            if (separatedList.get(i).equals(op)) {
                //실제로 연산을 진행
                long value = calculateValue(separatedList, i, op);
                // 3, 1 , + , 2 , 4
                //        3 
                separatedList.set(i, value+"");

                // if (i + 1 < separatedList.size()) {
                    separatedList.remove(i+1);
                // }

                separatedList.remove(i-1);
                i--;
            }
        }

        return separatedList;
    }
    
    //연산자에 따라 실제로 연산을 진행하는 함수
    private static long calculateValue(List<String> separatedList, int i, String op) {
        if ("+".equals(op)) {
            return Long.parseLong(separatedList.get(i - 1)) + Long.parseLong(separatedList.get(i + 1));
        } else if ("-".equals(op)) {
            return Long.parseLong(separatedList.get(i - 1)) - Long.parseLong(separatedList.get(i + 1));
        }else if("*".equals(op)){
            return Long.parseLong(separatedList.get(i - 1)) * Long.parseLong(separatedList.get(i + 1));
        }
        return -1;
    }

    private static List<String> separateExpression(String expression) {
        List<String> separated = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            //만약 숫자라면
            if(Character.isDigit(ch)) {
                sb.append(ch);
                continue;
            }
            //연산자라면 -> sb의 내용 저장 + 연산자 저장
            separated.add(sb.toString());
            separated.add(String.valueOf(ch));
            sb = new StringBuilder();
        }

        if(!(sb.length() == 0)){
            separated.add(sb.toString());
        }
        
        return separated;
    }
}