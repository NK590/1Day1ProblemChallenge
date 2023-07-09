package June;
import java.util.*;

public class Jaehyuck_programers_가장먼노드 {

	public static void main(String[] args) {
		int answer = 0;
		int n = 6;
		int [][] edge 	={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int [] distance = new int[n+1];
        boolean [] visit = new boolean[n+1];
        Queue<Integer> bfs = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        
        bfs.add(1);
        visit[1] = true;
        // 2~n 까지 node 갯수새기
         while (!bfs.isEmpty()) { 
            int now = bfs.poll();
            ArrayList<Integer> node = graph.get(now);
            for(int i = 0; i < node.size(); i++) {
                if (!visit[node.get(i)]) {
                     visit[node.get(i)] = true;
                    bfs.add(node.get(i));
                    distance[node.get(i)] = distance[now] + 1; 
                }      
            }  
        }
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for(int i=distance.length-1;distance[i]==max;i--){
            answer++;
        }
        
        
       System.out.print(answer);
	}

}
