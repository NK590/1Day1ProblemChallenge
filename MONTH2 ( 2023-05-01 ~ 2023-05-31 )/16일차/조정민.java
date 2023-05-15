// 백준 5557 - 1학년
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
	static int[] arr;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		String[] str = br.readLine().split(" ");
		arr = new int[n];
		dp = new long[21][n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}

		bw.append(dp(arr[0], 1) + "\n");
		bw.flush();
		bw.close();
	}

	public static long dp(int num, int idx) {
		if(idx == arr.length - 1) {
			if(num == arr[idx])
				return 1;
			else
				return 0;
		}

		long result = 0;

		if(num - arr[idx] >= 0) {
			if(dp[num - arr[idx]][idx + 1] == 0)
				dp[num - arr[idx]][idx + 1] = dp(num - arr[idx], idx + 1);

			result += dp[num - arr[idx]][idx + 1];
		}

		if(num + arr[idx] <= 20) {
			if(dp[num + arr[idx]][idx + 1] == 0)
				dp[num + arr[idx]][idx + 1] = dp(num + arr[idx], idx + 1);

			result += dp[num + arr[idx]][idx + 1];
		}

		return result;
	}

}

