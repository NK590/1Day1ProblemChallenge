package examplenote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example154540 {

    static int[] xdir = {0,0,-1,1};
    static int[] ydir = {-1,1,0,0};

    public static void main(String[] args) {


        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(solution(maps));
    }

    public static int[] solution(String[] maps){

        List<Integer> answer = new ArrayList<>();

        int height = maps.length;
        int width = maps[0].length();

        int[][] visited = new int[maps.length][maps[0].length()];

        char[][] map = new char[maps.length][];

        for(int i = 0; i < maps.length; i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] != 'X' && visited[i][j] == 0){
                    visited[i][j] = 1;
                    int isLand = bfs(i,j,map,visited,height,width);
                    if(isLand != 0){
                        answer.add(isLand);
                    }
                }
            }
        }

        Collections.sort(answer);

        if(answer.isEmpty()){
            answer.add(-1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static int bfs(int x, int y,char[][] map, int[][] visited,int height, int width){
        int temp = map[x][y]-'0';// ANSI Code 에서 '0' 뺌

        for(int i = 0; i < 4; i++){

            int dx = x +xdir[i];
            int dy = y +ydir[i];

            if(dx >= 0 && dx < height && dy >= 0 && dy < width){
                if(visited[dx][dy] == 0 && map[dx][dy] != 'X'){
                    visited[dx][dy] = 1;
                    temp+=bfs(dx,dy,map,visited,height,width);
                }
            }

        }
        return temp;
    }
}
