class Solution {
    public int[] solution(String[] wallpaper) {
        //시작점 S와 끝점 E를 정하는 것이 중요하다!
        //리턴 시작점, 끝점
        int[] answer = new int[4];
        //시작점은 length-1 으로 초기화
        int sx = wallpaper.length-1;
        int sy = wallpaper[0].length()-1;
        //끝점은 맨 앞으로 초기화
        int ex = 1;
        int ey = 1;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    //시작점 x보다 더 가깝다면
                    sy = j < sy ? j : sy;
                    ey = j+1 > ey ? j+1 : ey;
                    sx = i < sx ? i : sx;
                    ex = i+1 > ex ? i+1 : ex;
                    // if(j < sy){
                    //     sy = j;
                    // }
                    // if(j+1 > ey){
                    //     ey = j+1;
                    // }
                    // if(i < sx){
                    //     sx = i;
                    // }
                    // if(i+1 > ex){
                    //     ex = i+1;
                    // }
                }
            }
        }
        answer[0] = sx;
        answer[1] = sy;
        answer[2] = ex;
        answer[3] = ey;
        return answer;
    }
}