// 백준 7579 - 앱

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		String[] str = br.readLine().split(" ");
		int N = Integer.valueOf(str[0]);
		int M = Integer.valueOf(str[1]);

		int[] momories = new int [N];
		int[] costs = new int [N];
		int min = -1;
		int sum = 0;


		String[] str2 = br.readLine().split(" ");
		String[] str3 = br.readLine().split(" ");

		for(int i = 0; i < N; i++) {
			int memory = Integer.valueOf(str2[i]);
			int cost = Integer.valueOf(str3[i]);

			if(cost == 0) {
				M -= memory;
			} else if(memory >= M && (min == -1 || min > cost)) {
				min = cost;
			} else {
				momories[i] = memory;
				costs[i] = cost;
			}

			sum += cost;
		}


		if(M < 0) {
			min = 0;
		}

		int y = min == -1 ? sum : min;
		int[][] dp = new int[N+1][y+1];

		for(int i = 1; i <= N; i++) {
			int memory = momories[i-1];
			int cost = costs[i-1];

			for(int j = 1; j <= y; j++) {
				if(cost > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(memory + dp[i-1][j-cost],dp[i-1][j]);
				}

				if(dp[i][j] >= M && (min > j || min == -1)) {
					min = j;
				}
			}

		}

		System.out.println(min);
	}

}
