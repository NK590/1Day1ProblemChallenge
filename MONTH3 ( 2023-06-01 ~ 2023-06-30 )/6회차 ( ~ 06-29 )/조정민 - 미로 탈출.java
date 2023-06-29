import java.util.*;

class Solution {
    int[] X = {1, 0, -1, 0};
    int[] Y = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int answer = 0;        
        
        // bfs 로 S(시작 지점) -> L(레버), L(레버) -> E(출구) 2가지의 최소 경로를 구한 후 합친 값 출력 
        
        String[][] maps2 = new String[maps.length][maps[0].length()];
        int[] S = null;
        int[] L = null;
        int[] E = null;
        
        for(int i = 0; i < maps.length; i++) {
            maps2[i] = maps[i].split("");
            
            for(int j = 0; j < maps2[i].length; j++) {
                if(maps2[i][j].equals("S")) {
                    S = new int[] {i, j};
                } else if(maps2[i][j].equals("L")) {
                    L = new int[] {i, j};
                } else if(maps2[i][j].equals("E")) {
                    E = new int[] {i, j};
                } 
            }
        }
        
        // BFS 로 (S => L) + (L => E) 를 구한다.
        // S => L
        int a = bfs(S, L, maps2);        
        if(a == -1)
            return a;
        
        // l => E
        int b = bfs(L, E, maps2);        
        if(b == -1)
            return b;
        
        return a + b;
    }
    
    public int bfs(int[] from, int[] to, String[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[map.length][map[0].length];
        int cnt = 0;
        queue.add(from);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            
            while(size > 0) {
                int[] p = queue.poll();

                for(int i = 0; i < X.length; i++) {
                    int x = p[0] + X[i];
                    int y = p[1] + Y[i];                

                    if(x < 0 || x >= map.length || y < 0 || y >= map[0].length)
                        continue;

                    if(visited[x][y] == 1 || map[x][y].equals("X"))
                        continue;
                    
                    if(x == to[0] && y == to[1]) {
                        return cnt;
                    }

                    queue.add(new int[] {x, y});
                    visited[x][y] = 1;
                }
                
                size--;
            }
        }        
        
        return -1;
    }
}
