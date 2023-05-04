// 나이트의 이동

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] X = {2, 2, -2, -2, 1, -1, 1, -1};
	static int[] Y = {1, -1, 1, -1, 2, 2, -2, -2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());

		while(n-- > 0) {
			int l = Integer.valueOf(br.readLine());
			String[] start = br.readLine().split(" ");
			String[] end = br.readLine().split(" ");
			int x = Integer.valueOf(start[0]);
			int y = Integer.valueOf(start[1]);
			int x2 = Integer.valueOf(end[0]);
			int y2 = Integer.valueOf(end[1]);

			boolean[][] visited = new boolean[l][l];

			for(int i = 0; i < l; i++) {
				Arrays.fill(visited[i], false);
			}

			int reuslt = bfs(visited, new int[] {x, y}, new int[] {x2, y2});

			bw.append(reuslt + "\n");
		}

		bw.flush();
		bw.close();
	}

	public static int bfs(boolean[][] visited, int[] arr, int[] target) {
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		queue.add(arr);

		while(!queue.isEmpty()) {
			int size = queue.size();

			while(size-- > 0) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];

				if(x == target[0] && y == target[1])
					return cnt;

				if(visited[x][y])
					continue;

				visited[x][y] = true;

				for(int i = 0; i < 8; i++) {
					int x2 = x + X[i];
					int y2 = y + Y[i];

					if(x2 < 0 || x2 >= visited.length || y2 < 0 || y2 >= visited.length)
						continue;

					if(visited[x2][y2])
						continue;

					queue.add(new int[] {x2, y2});
				}
			}

			cnt++;
		}

		return cnt;
	}
}
