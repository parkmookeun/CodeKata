class Solution {
     public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int sx = 0;
        int sy = 0;
        //강아지 처음 위치 파악
        for(int i=0; i<park.length; i++){
            int yIdx = park[i].indexOf('S');
            if(yIdx != -1){
                sx = i;
                sy = yIdx;
                break;
            }
        }
        //루트(길) 돌면서 강아지 이동
        int dist = 0;
        boolean go = false;

        for(int i=0; i<routes.length; i++){
            dist = Character.getNumericValue(routes[i].charAt(2));
//            System.out.println("거리는"+dist);
            go = true;
            if(routes[i].charAt(0) == 'E'){
                //방애물과 경계밖 검사
                for(int j=0; j<=dist; j++){
//                    System.out.println("동쪽으로 "+j);
                    if((sy+j) >= park[sx].length() || park[sx].charAt(sy+j) == 'X'){
                        go = false;
                        break;
                    }
                }
                if(!go) continue;
                sy = sy + dist;
//                System.out.printf("(%d,%d)%n",sx,sy);
            }
            else if(routes[i].charAt(0) == 'W'){
                //방애물과 경계밖 검사
                for(int j=0; j<=dist; j++){
                    if((sy-j) < 0 || park[sx].charAt(sy-j) == 'X'){
                        go = false;
                        break;
                    }
                }
                if(!go) continue;
                sy = sy - dist;
//                System.out.printf("(%d,%d)%n",sx,sy);
            }
            else if(routes[i].charAt(0) == 'S'){
                //방애물과 경계밖 검사
                for(int j=0; j<=dist; j++){
                    if((sx+j) >= park.length || park[sx+j].charAt(sy) == 'X'){
                        go = false;
                        break;
                    }
                }
                if(!go) continue;
                sx = sx + dist;
//                System.out.printf("(%d,%d)%n",sx,sy);
            }
            else if(routes[i].charAt(0) == 'N'){
                //방애물과 경계밖 검사
                for(int j=0; j<=dist; j++){
                    if((sx-j) < 0 || park[sx-j].charAt(sy) == 'X'){
                        go = false;
                        break;
                    }
                }
                if(!go) continue;
                sx = sx - dist;
//                System.out.printf("(%d,%d)%n",sx,sy);
            }
        }
        answer[0] = sx;
        answer[1] = sy;
        return answer;
    }
}