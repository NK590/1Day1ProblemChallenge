// 백준 2011 - 암호코드

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
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        arr = new int[str.length];
        dp = new long[str.length + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }

        bw.append(dp(0) + "\n");
        bw.flush();
        bw.close();
    }

    public static long dp(int idx) {
        if(idx >= arr.length) {
            return 1;
        }

        if(arr[idx] == 0)
            return 0;

        long result = 0;

        if(idx <= arr.length - 2) {
            int sum = arr[idx] * 10 + arr[idx + 1];

            if(sum <= 26) {
                if (dp[idx + 2] != 0)
                    result += dp[idx + 2] % 1000000;
                else
                    result += dp[idx + 2] = dp(idx + 2) % 1000000;
            }
        }

        if (dp[idx + 1] != 0)
            result += dp[idx + 1] % 1000000;
        else
            result += dp[idx + 1] = dp(idx + 1) % 1000000;


        return result % 1000000;
    }

}

