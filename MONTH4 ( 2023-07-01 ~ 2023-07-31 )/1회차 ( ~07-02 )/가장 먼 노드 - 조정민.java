import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

// 		Queue<Integer> queue = new LinkedList<>();
// 		int[] node_list = new int[n];
// 		int now_node;
// 		int cnt = 0;
// 		node_list[0] = 1;
// 		queue.offer(1);
// 		queue.offer(0);

// 		do {
// 			now_node = (int) queue.poll();
// 			if (now_node != 0) {
// 				for (int i = 0; i < edge.length; i++) {
// 					if (edge[i][0] == now_node) {
// 						if (node_list[edge[i][1] - 1] == 0) {
// 							queue.offer(edge[i][1]);
// 							node_list[edge[i][1] - 1] = 1;
// 							cnt++;
// 						}
// 					} else if (edge[i][1] == now_node) {
// 						if (node_list[edge[i][0] - 1] == 0) {
// 							queue.offer(edge[i][0]);
// 							node_list[edge[i][0] - 1] = 1;
// 							cnt++;
// 						}
// 					}
// 				}
// 			} else {
// 				boolean run = true;

// 				for (int x : node_list) {
// 					if (x == 0) {
// 						run = false;
// 					}
// 				}

// 				if (run) {
// 					System.out.println(cnt);
// 					return cnt;
// 				} else {
// 					queue.offer(0);
// 					cnt = 0;
// 				}
// 			}
// 		} while (queue.peek() != null);

        List<List<Integer>> graph = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //[0] = node, [1] = cost
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        for(int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }

        dist[0] = 0;
        dist[1] = 0;
        pq.add(new int[] {1, 0});

        while(!pq.isEmpty()) {
            int[] num = pq.poll();

            for(Integer x : graph.get(num[0])) {
                if(dist[x] > dist[num[0]] + 1) {
                    dist[x] = dist[num[0]] + 1;
                    pq.add(new int[] {x, dist[x]});
                }
            }

        }

        int max = 0;
        for(int x : dist) {
            if(x > max) {
                max = x;
                answer = 0;
            }

            if(x == max) {
                answer++;
            }
        }

        return answer;
    }
}
