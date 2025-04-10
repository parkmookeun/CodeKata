
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int subTotal = 0;
    static int N;
    static int M;
    static int K = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //지도 초기화
        int[][] maps = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //동: 0 , 서: 1, 남:2, 북:3
        //주사위 초기화
        int[][] dice = {{0,2,0,0},{4,1,3,6},{0,5,0,0},{0,6,0,0}};
        boolean[][] visited;

        int[] start = {0,0};
        int bottom = 6;
        int direction = 0;


        while(K > 0){
            //이동 방향으로 한칸 움직이기
            if((start[0] + dx[direction]) < 0 || (start[0] + dx[direction]) >= N){
                start[0] -= dx[direction];
                direction = direction % 2 == 0 ? 3 : 2;
            }else{
                start[0] += dx[direction];
            }

            if((start[1] + dy[direction]) < 0 || (start[1] + dy[direction]) >= M){
                start[1] -= dy[direction];
                direction = direction % 2 == 0 ? 1 : 0;
            }else{
                start[1] += dy[direction];
            }
            //주사위 정보 반영
            rollDice(dice, direction);
            bottom = dice[1][3];
            //방향 바꾸기

            visited = new boolean[N][M];
            dfs(maps,start,visited,maps[start[0]][start[1]]);
            answer += subTotal*maps[start[0]][start[1]];
            subTotal = 0;

            K--;


            if(maps[start[0]][start[1]] < bottom){
                switch (direction){
                    case 0: direction = 2; break;
                    case 1: direction = 3; break;
                    case 2: direction = 1; break;
                    case 3: direction = 0;
                }
            }else if(maps[start[0]][start[1]] > bottom){
                switch (direction){
                    case 0: direction = 3; break;
                    case 1: direction = 2; break;
                    case 2: direction = 0; break;
                    case 3: direction = 1;
                }
            }
        }


        System.out.println(answer);

        }

    private static void rollDice(int[][] dice, int direction) {
        int temp = 0;
        switch (direction){
            case 0:
                temp = dice[1][3];
                //동쪽
                for(int i=0; i<3; i++){
                    dice[1][3-i] = dice[1][2-i];
                }
                dice[1][0] = temp;
                dice[3][1] = dice[1][3];
                break;
            case 1:
                temp = dice[1][0];
                //서쪽
                for(int i=0; i<3; i++){
                    dice[1][i] = dice[1][i+1];
                }
                dice[1][3] = temp;
                dice[3][1] = dice[1][3];
                break;
            case 2:
                //남쪽
                temp = dice[3][1];
                for(int i=0; i<3; i++){
                    dice[3-i][1] = dice[2-i][1];
                }
                dice[0][1] = temp;
                dice[1][3] = dice[3][1];
                break;
            case 3:
                //북쪽
                temp = dice[0][1];
                for(int i=0; i<3; i++){
                    dice[i][1] = dice[i+1][1];
                }
                dice[3][1] = temp;
                dice[1][3] = dice[3][1];
                break;

        }
    }

    static void dfs(int[][] maps, int[] start, boolean[][] visited, int value) {
            visited[start[0]][start[1]] = true;
            subTotal++;
            for(int i=0; i<4; i++){
                int sx = start[0] + dx[i];
                int sy = start[1] + dy[i];
                if(sx >= 0 && sx < N && sy >= 0 && sy < M && maps[sx][sy] == value && !visited[sx][sy]){
                    dfs(maps,new int[]{sx,sy},visited, value);
                }
            }
    }
}
