// 백준 2293 - 동전 1

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		int n = Integer.valueOf(str[0]);
		int k = Integer.valueOf(str[1]);

		int[] arr = new int[n];
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		for(int i = 1 ; i < n + 1; i++) {
			dp[i][0] = 1;
		}

		for(int i = 1 ; i < dp.length; i++) {
			for(int j = 1 ; j < dp[0].length; j++) {
				if(arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		bw.append(dp[n][k] + "\n");
		bw.flush();
		bw.close();
	}

}

