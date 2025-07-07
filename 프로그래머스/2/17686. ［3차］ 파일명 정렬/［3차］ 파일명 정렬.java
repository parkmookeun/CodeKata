/*
  핵심 아이디어 : 커스텀 정렬 기준으로 정렬할 수 있는가?
  
  파일 정렬 문제
  파일정렬정보 클래스를 만든다. -> ORIGINAL_FILE, HEAD, NUMBER, TAIL
  
  1. 먼저 파일의 HEAD 추출, NUMBER 추출, 배열의 인덱스 추출
  2. 파일정렬정보를 1번에서 얻은 정보로 생성한다.
  3. 파일정렬정보에서 Comparable을 구현한다. -> compare함수에서 정렬 기준 잡기
  4. 리스트에 해당 파일정렬정보 인스턴스를 계속해서 추가한다.
  5. 리스트.sort(null);
  6. 리스트.originalFile만 answer 배열에 저장 -> 끝
*/

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        //정답을 담을 배열
        String[] answer = new String[files.length];

        //파일정렬정보가 담긴 리스트
        List<FileSortInfo> fileList = new ArrayList<>();

        //파일 하나씩 검사
        for (int i = 0; i < files.length; i++) {
            //numIdx는 숫자가 시작하는 인덱스
            //stringIdx는 숫자가 끝나는 인덱스 즉, tail이 시작하는 인덱스
            int numIdx = 0;
            int stringIdx = 0;
            
            //numIdx 찾기
            for (int j = 0; j < files[i].length(); j++) {
                char ch = files[i].charAt(j);
                if(Character.isDigit(ch)){
                    numIdx = j;
                    break;
                }
            }
            
            //stringIdx 찾기
            int count = 0;
            for (int j = numIdx; j < files[i].length(); j++) {
                count++;
                char ch = files[i].charAt(j);
                
                //숫자가 아닌 문자가 나오면
                if(!Character.isDigit(ch)){
                    stringIdx = j;
                    break;
                }
                
                //인덱스가 마지막까지 온경우
                if(j == files[i].length() - 1){
                    stringIdx = files[i].length();
                    break;
                }
                //최대 5숫자까지 가능
                 if(count == 5){
                    stringIdx = j + 1;
                    break;
                }
            }

            String head = files[i].substring(0, numIdx).toLowerCase();
            int number = Integer.valueOf(files[i].substring(numIdx, stringIdx));
            
            fileList.add(new FileSortInfo(files[i],head,number, i));
        }
        
        //내가 정한 정렬 기준대로 정렬
        fileList.sort(null);
        
        // System.out.println(fileList);
        
        //마지막으로 정답배열에 담기
        for(int i=0; i<fileList.size(); i++){
            answer[i] = fileList.get(i).originalFile;   
        }
        
        return answer;
    }

    class FileSortInfo implements Comparable{
        public String originalFile;
        private String head;
        private int number;
        private int index;

        public FileSortInfo(String originalFile, String head, int number, int index) {
            this.originalFile = originalFile;
            this.head = head;
            this.number = number;
            this.index = index;
        }

        @Override
        public int compareTo(Object o) {
            FileSortInfo info = (FileSortInfo) o;

            
            if(head.equals(info.head)){
                if(number == info.number){
                    return Integer.compare(index, info.index);
                }
                return Integer.compare(number, info.number);
            }
            
            return head.compareTo(info.head);
        }
    
        @Override
        public String toString(){
            return originalFile;
        }
    }
}