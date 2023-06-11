import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        Arrays.fill(visited, false);
        
        for(int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean flag = false;
            queue.add(i);

            while(!queue.isEmpty()) {
                int x = queue.poll();
                if(visited[x]) continue;

                visited[x] = true;

                for(int j = 0; j < n; j++) {
                    if(i == j) continue;

                    if(computers[x][j] == 0 || visited[j]) continue;

                    queue.add(j);
                }
                
                flag = true;
            }
            
            if(flag)
                answer++;
        }
        
        return answer;
    }
}
