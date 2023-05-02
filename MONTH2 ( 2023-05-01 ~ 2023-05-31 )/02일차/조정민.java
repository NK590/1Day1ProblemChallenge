// 백준 4963 - 섬의 개수

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] X = {0, 1, 0, -1, 1, -1, 1, -1};
	static int[] Y = {1, 0, -1, 0, 1, -1, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String[] str = br.readLine().split(" ");
			int w = Integer.valueOf(str[0]);
			int h = Integer.valueOf(str[1]);
			int cnt = 0;

			if(w == 0 && h == 0)
				break;

			String[][] map = new String[h][w];
			boolean[][] visited = new boolean[h][w];

			for(int i = 0; i < h; i++) {
				map[i] = br.readLine().split(" ");
				Arrays.fill(visited[i], false);
			}

			for(int i = 0; i < h; i ++) {
				for(int j = 0; j < w; j++) {
					if(visited[i][j])
						continue;

					bfs(map, visited, new int[] {i, j});

					if(map[i][j].equals("1"))
						cnt++;
				}
			}

			bw.append(cnt + "\n");
		}

		bw.flush();
		bw.close();
	}

	public static void bfs(String[][] map, boolean[][] visited, int[] arr) {
		Queue<int[]> queue = new LinkedList<>();
		String s = map[arr[0]][arr[1]];
		queue.add(arr);

		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];

			if(visited[x][y])
				continue;

			visited[x][y] = true;

			for(int i = 0; i < 8; i++) {
				int x2 = x + X[i];
				int y2 = y + Y[i];

				if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
					continue;

				if(visited[x2][y2])
					continue;

				if(!map[x2][y2].equals(s))
					continue;

				queue.add(new int[] {x2, y2});
			}
		}
	}
}
