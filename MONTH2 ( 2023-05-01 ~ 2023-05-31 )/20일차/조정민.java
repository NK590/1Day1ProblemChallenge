// 백준 13699 - 점화식

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		BigInteger[] dp = new BigInteger[num+1];

		for(int i = 0; i <= num; i++) {

			if(i == 0)
				dp[i] = new BigInteger("1");

			else {
				dp[i] = new BigInteger("0");
				for(int j = 0; j < i; j++) {
					dp[i] = dp[i].add(dp[i-j-1].multiply(dp[j]));
				}
			}
		}

		System.out.println(dp[num]);
	}
}

