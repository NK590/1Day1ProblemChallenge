// 백준 2294 - 동전 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		int n = Integer.valueOf(str[0]);
		int m = Integer.valueOf(str[1]);

		int[] arr = new int[n];
		int[] dp = new int[m + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}

		Arrays.sort(arr);

		Loop1: for (int i = 1; i <= m; i++) {
			for (int x : arr) {
				if (x > m)
					continue Loop1;

				if (x == i) {
					dp[i] = 1;
				} else if (x < i) {
					if (dp[i - x] == 0)
						continue;

					int y = dp[i - x] + 1;

					if (dp[i] == 0 || dp[i] > y) {
						dp[i] = y;
					}
				}
			}
		}

		System.out.println((dp[m] == 0) ? -1 : dp[m]);
	}
}
