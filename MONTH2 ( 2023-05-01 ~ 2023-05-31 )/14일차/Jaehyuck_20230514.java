package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 silver lv2 가장 긴 증가하는 부분 수열 (11053)
// https://www.acmicpc.net/problem/11053
public class Jaehyuck_20230514 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int [] dp = new int[n+1];
		int [] num = new int[n+1];
		Arrays.fill(dp, 1);
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(num[i]>num[j]) {
					
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}

}
