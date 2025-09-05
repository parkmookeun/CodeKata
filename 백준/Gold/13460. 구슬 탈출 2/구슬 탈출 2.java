import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 13460번 - 구슬 탈출 2
 *
 * 핵심 아이디어 : BFS
 *
 * 1. 보드의 상태를 나타낼 배열 String[][] board
 * 2. 빨간공의 현재 위치와 파란공의 현재 위치를 나타낼 int[] redPos, int[] bluePos
 * 3. 기울였을 때 이동하는 함수
 *    1) 장애물이 닿을때까지 그 방향으로 이동
 *    2) 빨간공과 파란공 겹칠 수 없음
 *    3) 동시에 빠져나갔을 때 +
 */
public class Main {
    static int N;
    static int M;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        String[][] board = new  String[N][M];
        int[] redPos =  new int[2];
        int[] bluePos =  new int[2];

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                String value = String.valueOf(str.charAt(j));
                if(value.equals("R")){
                    redPos[0] = i;
                    redPos[1] = j;
                }
                if(value.equals("B")){
                    bluePos[0] = i;
                    bluePos[1] = j;
                }
                board[i][j] = value;
            }
        }

        //보드 출력해보기
        //System.out.println(Arrays.deepToString(board));
        //빨강 공 위치 출력
        //System.out.println("("+redPos[0]+","+redPos[1]+")");
        //파란 공 위치 출력
        //System.out.println("("+bluePos[0]+","+bluePos[1]+")");


        //BFS함수
        BFS(redPos, bluePos, board);

        System.out.println(answer);
    }

    private static void BFS(int[] redPos, int[] bluePos, String[][] board) {
        //북, 남, 서, 동
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        //
        String[] dir = new String[]{"북","남","서","동"};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][][][] visited = new  boolean[N][M][N][M];

        int[] pos = new int[5];
        pos[0] = redPos[0];
        pos[1] = redPos[1];
        pos[2] = bluePos[0];
        pos[3] = bluePos[1];
        pos[4] = 1;

        queue.offer(pos);
        visited[pos[0]][pos[1]][pos[2]][pos[3]] = true;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            //목적지 검사
            if(curPos[4] > 10){
                answer = -1;
                break;
            }
            //4방향 검사
            for(int i = 0; i < 4; i++) {
                boolean redExit = false;
                boolean blueExit = false;

                int rx = curPos[0];
                int ry = curPos[1];
                int bx = curPos[2];
                int by = curPos[3];
                //System.out.println("기울기 시작: " + dir[i] + ", 깊이: " + curPos[4]);
                //System.out.println("빨간공 시작: (" + rx + "," + ry + ")");
                //System.out.println("파란공 시작: (" + bx + "," + by + ")");
                //공이 더이상 움직이지 못할때까지(동시에 움직임)
                while(true){
                    int move_rx = rx + dx[i];
                    int move_ry = ry + dy[i];
                    int move_bx = bx + dx[i];
                    int move_by = by + dy[i];

                    //빨강 공 앞에 파란 공이 있고, 파란 공 앞이 벽이라면 더이상 못감
                    if((move_rx == bx && move_ry == by) && board[move_bx][move_by].equals("#")){
                        break;
                    }
                    //파란 공 앞에 빨간 공이 있고, 빨간 공 앞이 벽이라면 더이상 못감
                    if((move_bx == rx && move_by == ry) && board[move_rx][move_ry].equals("#")){
                        break;
                    }
                    //두 공 앞이 다 벽인경우 못감
                    if(board[move_bx][move_by].equals("#") && board[move_rx][move_ry].equals("#")){
                        break;
                    }

                    //둘다 탈출한 경우 더이상 못감
                    if(redExit && blueExit){
                        break;
                    }

                    if(redExit && board[move_bx][move_by].equals("#")) break;
                    if(blueExit && board[move_rx][move_ry].equals("#")) break;

                    //이제부터 공 하나씩은 움직일 수 있는 상황
                    if(!redExit && !board[move_rx][move_ry].equals("#")){
                        //System.out.println("빨간 공이 움직입니다.");
                        //만약 다음 칸이 탈출구라면
                        if(board[move_rx][move_ry].equals("O")){
                            //System.out.println("빨간 공이 탈출했습니다");
                            redExit = true;
                        }else{
                            rx = move_rx;
                            ry = move_ry;
                        }
                    }

                    if(!blueExit && !board[move_bx][move_by].equals("#")){
                        //System.out.println("파란 공이 움직입니다.");
                        //만약 다음 칸이 탈출구라면
                        if(board[move_bx][move_by].equals("O")){
                            blueExit = true;
                        }else{
                            bx = move_bx;
                            by = move_by;
                        }
                    }
                    //만약 빨간 공이 빠져나왔다면(파란 공은 빠져 나오면 안됨!)
                }

                if(redExit && !blueExit){
                    answer = curPos[4];
                    return;
                }

                //큐에 넣기
                if((!visited[rx][ry][bx][by]) && !redExit && !blueExit){
                    //System.out.println("큐에 넣습니다.");
                    //System.out.println("빨간 공: ("+ rx + "," + ry + ")");
                    //System.out.println("파란 공: ("+ bx + "," + by + ")");
                    visited[rx][ry][bx][by] = true;
                    queue.offer(new int[]{rx, ry,bx,by,curPos[4]+1});
                }
            }
        }
        if (queue.isEmpty()) {
            answer =  -1;
        }
    }
}