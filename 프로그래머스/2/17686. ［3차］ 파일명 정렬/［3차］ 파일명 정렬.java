/*
  파일 정렬 문제
  파일 -> HEAD, NUMBER, TAIL
  
  1. 먼저 파일의 HEAD 추출, NUMBER 추출, 배열의 인덱스 추출
  2. 
*/

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<FileSortInfo> fileList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            int numIdx = 0;
            int stringIdx = 0;

            for (int j = 0; j < files[i].length(); j++) {
                char ch = files[i].charAt(j);
                if(Character.isDigit(ch)){
                    numIdx = j;
                    break;
                }
            }
            
            int count = 0;
            for (int j = numIdx; j < files[i].length(); j++) {
                count++;
                char ch = files[i].charAt(j);
                
            
                if(!Character.isDigit(ch)){
                    stringIdx = j;
                    break;
                }
                
                if(j == files[i].length() - 1){
                    stringIdx = files[i].length();
                    break;
                }
                
                 if(count == 5){
                    stringIdx = j + 1;
                    break;
                }
            }

            String head = files[i].substring(0, numIdx).toLowerCase();
            int number = Integer.valueOf(files[i].substring(numIdx, stringIdx));
            
            fileList.add(new FileSortInfo(files[i],head,number, i));
        }
        
        fileList.sort(null);
        System.out.println(fileList);
        
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

            //1. 먼저 헤드가 그거인기
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