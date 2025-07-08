/*
    핵심 아이디어 : 구현 문제라고 생각한다.
    1. 먼저 지정한 위치에서 직사각형인지 검사하는 함수를 만든다.
    2. 직사각형이면 해당 위치를 다 빈칸 처리하는 함수를 만든다.
    3. 직사각형이 없어진 자리를 메꾸기 위해 이동시키는 함수를 만든다.
    
    1->2->3을 반복한다. (더이상 직사각형이 없을 때까지)
    
*/
import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int m, int n, String[] board) {
        
        //board를 2차원 배열로
        char[][] boardMap = new char[m][n];
        
        for(int i=0; i<boardMap.length; i++){
            for(int j=0; j<boardMap[0].length; j++){
                boardMap[i][j] = board[i].charAt(j);
            }
        }
        
        boolean isSquareExisted = true;
        // System.out.println("=== 오리지날 ===");
        // printDeepArrays(boardMap);
        // System.out.println("==========");
        while(isSquareExisted){
            Set<Point> tileSet = new HashSet<>();
            
            //타일 검사 쫙 하기
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                   int[][] disAppear = findSquare(boardMap, m, n, i, j);
                    // System.out.println(Arrays.deepToString(disAppear));
                   for(int k=0; k<4; k++){
                   if(disAppear[k][0] == -1) break;
                   tileSet.add(new Point(disAppear[k][0],disAppear[k][1]));
                   }
                }
            }
            
            // System.out.println(tileSet);
            
            //Set에 들어간 개수 -> answer 에 더해주기
            // System.out.println("없어진 타일 개수: " + tileSet.size());
            answer += tileSet.size();
            
            //Set에 들어간 타일 빈칸으로 만들어 주기
            blankSquare(tileSet, boardMap);
            // System.out.println("없어진 타일 빈칸 채우기");
            // printDeepArrays(boardMap);
            //이제 위치 변경해주기
            moveBoard(boardMap);
            // System.out.println("타일 옮기기");
            // printDeepArrays(boardMap);
            // System.out.println("==================");
            if(tileSet.isEmpty()) isSquareExisted = false;
        }
        
        return answer;
    }
    
    // 직사각형 검사해서 맞으면 반환
    int[][] findSquare(char[][] board, int m, int n, int x, int y){
        
        int[][] squareTiles = new int[4][2];
        int tileIdx = 0;
        
        squareTiles[tileIdx][0] = x;
        squareTiles[tileIdx][1] = y;
        
        
        char value = board[x][y];
        //
        if(value == '0'){
         int[][] nothingArr = new int[4][2];
            for(int[] arr : nothingArr){
                Arrays.fill(arr, -1);
            }
            return nothingArr;
        }
        
        int[] dx = {1,1,0};
        int[] dy = {0,1,1};
        
        for(int i=0; i<3; i++){
            int sx = x + dx[i];
            int sy = y + dy[i];
            
            if(sx >= m || sy >= n){
                int[][] nothingArr = new int[4][2];
                for(int[] arr : nothingArr){
                    Arrays.fill(arr, -1);
                }
                return nothingArr;
            } 
            
            if(board[sx][sy] != value){
                int[][] nothingArr = new int[4][2];
                for(int[] arr : nothingArr){
                    Arrays.fill(arr, -1);
                }
                return nothingArr;
            }
            
            //직사각형인 경우
            tileIdx++;
            squareTiles[tileIdx][0] = sx;
            squareTiles[tileIdx][1] = sy;
            
        }        
        return squareTiles;
    }
    
    public void blankSquare(Set<Point> set, char[][] board){
        for(Point tile : set){
            board[tile.x][tile.y] = '0';
        }
    }
    
    public void moveBoard(char[][] board){
        //첫번째 열부터 마지막 열까지 검사
        //아래에서부터 검사
        
        for(int i=0; i<board[0].length; i++){
            int zeroCount = 0;
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<board.length; j++){
                if(board[j][i] == '0') zeroCount++;
                else{
                    sb.append(board[j][i]);
                }
            }
            
            sb.insert(0,"0".repeat(zeroCount));
            
            if(zeroCount != 0)
            for(int j=0; j<board.length; j++){
                board[j][i] = sb.toString().charAt(j);
            }
        }
    }
    
    public void printDeepArrays(char[][] board){
        for(char[] arr : board){
            System.out.println(Arrays.toString(arr));
        }
    }
    
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            
            return this.x == p.x && this.y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
