// 백준 1967 - 트리의 지름

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static List<List<int[]>> graph;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		graph = new ArrayList<>();
		visited = new boolean[n + 1];

		for(int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		Arrays.fill(visited, false);

		for(int i = 0; i < n - 1; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int c = Integer.valueOf(str[2]);

			graph.get(a).add(new int[] {b, c});
		}

		bfs(1);

		bw.append(answer + "\n");
		bw.flush();
		bw.close();
	}

	static int bfs(int node) {
		List<int[]> list = graph.get(node);

		if(list.size() == 0)
			return 0;

		List<Integer> childList = new ArrayList<>();

		for(int[] x : list) {
			childList.add(bfs(x[0]) + x[1]);
		}

		Collections.sort(childList, Collections.reverseOrder());
		childList.add(0);

//		if(answer < childList.get(0) + childList.get(1)) {
//			System.out.println(node + " = " + answer + " : " + (childList.get(0) + childList.get(1)));
			answer = Math.max(answer, childList.get(0) + childList.get(1));
//		}


		return childList.get(0);
	}
}
