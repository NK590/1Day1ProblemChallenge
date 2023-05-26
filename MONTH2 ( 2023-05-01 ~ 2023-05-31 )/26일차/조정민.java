// 백준 1563 - 개근상

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        dp = new int[n + 1][2][3];

        bw.append(dp(n, 0, 0, 0) + "\n");
        bw.flush();
        bw.close();

    }

    public static int dp(int n, int d, int l, int a) {
        if(n == d++)
            return 1;

        int result = 0;

        if(dp[d][l][a] != 0)
            return dp[d][l][a];

        if(l == 0) {
            result += dp(n, d, 1, 0) % 1000000;
        }

        if(a != 2) {
            result += dp(n, d, l, a + 1) % 1000000;
        }

        result += dp(n, d, l, 0) % 1000000;
        dp[d][l][a] = result;

        return result % 1000000;
    }
}

