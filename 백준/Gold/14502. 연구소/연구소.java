
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int virusCount;
    static int answer;
    static int wallCount;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] maps;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> virus = new ArrayList<>();
        ArrayList<int[]> wall = new ArrayList<>();

        boolean[][] visited;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            while(st.hasMoreTokens()){
                int value = Integer.parseInt(st.nextToken());
                maps[i][idx++] = value;

                if(value == 0){
                    list.add(new int[]{i,idx-1}); // 빈칸인 부분 리스트에 저장
                }else if(value == 1){
                    wall.add(new int[]{i,idx-1});
                }
                else if(value == 2) {
                    virus.add(new int[]{i,idx-1});// 바이러스 리스트에 저장
                }
            }
        }
        //맵 출력해보기
//        printMaps(maps);

        wallCount = wall.size() + 3;
        
        for(int i=0; i<list.size()-2; i++){
            int[] first = list.get(i);
            maps[first[0]][first[1]] = 1;
            for(int j=i+1; j<list.size()-1; j++){
                int[] second = list.get(j);
                maps[second[0]][second[1]] = 1;
                for(int k=j+1; k<list.size(); k++){
                    int[] third = list.get(k);
                    maps[third[0]][third[1]] = 1;
                    //여기에다가 바이러스 증식 함수
                    visited = new boolean[N][M];
                    for (int l=0; l<virus.size(); l++){
                        virusExpand(virus.get(l),visited);
                    }
                    answer = Math.max(answer, N*M - wallCount - virusCount);
                    virusCount = 0;
                    maps[third[0]][third[1]] = 0;
                }
                maps[second[0]][second[1]] = 0;
            }
            maps[first[0]][first[1]] = 0;
        }
        System.out.println(answer);

    }

    private static void virusExpand(int[] location, boolean[][] visited) {
        visited[location[0]][location[1]] = true;
        virusCount++;

        for(int i=0; i<4; i++){
            int sx = location[0] + dx[i];
            int sy = location[1] + dy[i];

            if(sx >= 0 && sx < N && sy >= 0 && sy < M && !visited[sx][sy] && maps[sx][sy] == 0){
                virusExpand(new int[]{sx,sy},visited);
            }
        }
    }


//    private static void printBlanks(ArrayList<int[]> list) {
//        for(int[] value : list){
//            System.out.println(value[0] + "," + value[1]);
//        }
//    }
//
//    private static void printMaps(int[][] maps) {
//        for(int i=0; i<maps.length; i++){
//            for(int j=0; j<maps.length; j++){
//                System.out.print(maps[i][j]);
//            }
//            System.out.println();
//        }
//    }
}
