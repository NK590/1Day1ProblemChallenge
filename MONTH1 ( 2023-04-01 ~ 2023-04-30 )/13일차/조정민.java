// 프로그래머스 - 게임 맵 최단거리

import java.util.*;

class Solution {
    int[] X = {1, 0, -1, 0};
    int[] Y = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        queue.add(new int[] {0, 0});
        
        Loop1 : while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size > 0) {
                size--;
                
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                
                // System.out.println(x + " : " + y);
                
                if(visited[x][y] == 1)
                    continue;
                
                visited[x][y] = 1;
                
                if(x == n - 1 && y == m - 1)
                    break Loop1;
                
                for(int i = 0; i < 4; i++) {
                    int x2 = x + X[i];
                    int y2 = y + Y[i];
                    
                    if(x2 < 0 || x2 >= n || y2 < 0 || y2 >= m)
                        continue;
                    
                    if(visited[x2][y2] == 1 || maps[x2][y2] == 0)
                        continue;
                    
                    queue.add(new int[] {x2, y2});
                }
            }
            
            answer++;
        }
        
        if(visited[n - 1][m - 1] == 0)
            return -1;
        else
            return answer;
    }
}
