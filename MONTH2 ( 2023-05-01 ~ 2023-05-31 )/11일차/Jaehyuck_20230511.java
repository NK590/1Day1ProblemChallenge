package May;
import java.util.Scanner;
// 백준 silver lv3 1,2,3 더하기 (9095)
// https://www.acmicpc.net/problem/9095

public class Jaehyuck_20230511 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int j =0;
		int [] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i =0;i<n;i++) {
			j = sc.nextInt();
				for(int x=4;x<=j;x++) {
					dp[x] = dp[x-1]+dp[x-2]+dp[x-3];
				}
			System.out.println(dp[j]);
		}
	}

}
