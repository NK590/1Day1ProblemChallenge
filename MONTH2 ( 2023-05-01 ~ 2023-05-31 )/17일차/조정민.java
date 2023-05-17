// 백준 17404 - RGB거리 2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.MAX_VALUE;
        int n = Integer.valueOf(br.readLine());
        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.valueOf(str[0]);
            int b = Integer.valueOf(str[1]);
            int c = Integer.valueOf(str[2]);

            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }

        // 1번을 선택할 경우
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = Integer.MAX_VALUE / 2;
        dp[0][2] = Integer.MAX_VALUE / 2;
        dp[1][0] = Integer.MAX_VALUE / 2;
        dp[1][1] = dp[0][0] + arr[1][1];
        dp[1][2] = dp[0][0] + arr[1][2];

        for(int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(arr[i - 1][1] + Math.min(dp[i - 2][0], dp[i - 2][2]),
                    arr[i - 1][2] + Math.min(dp[i - 2][0], dp[i - 2][1]));
            dp[i][1] = arr[i][1] + Math.min(arr[i - 1][0] + Math.min(dp[i - 2][1], dp[i - 2][2]),
                    arr[i - 1][2] + Math.min(dp[i - 2][0], dp[i - 2][1]));
            dp[i][2] = arr[i][2] + Math.min(arr[i - 1][0] + Math.min(dp[i - 2][1], dp[i - 2][2]),
                    arr[i - 1][1] + Math.min(dp[i - 2][0], dp[i - 2][2]));
        }

        answer = Math.min(answer, Math.min(dp[n - 1][1], dp[n - 1][2]));

        // 2번을 선택할 경우
        dp = new int[n][3];
        dp[0][0] = Integer.MAX_VALUE / 2;
        dp[0][1] = arr[0][1];
        dp[0][2] = Integer.MAX_VALUE / 2;
        dp[1][0] = dp[0][1] + arr[1][0];
        dp[1][1] = Integer.MAX_VALUE / 2;
        dp[1][2] = dp[0][1] + arr[1][2];

        for(int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(arr[i - 1][1] + Math.min(dp[i - 2][0], dp[i - 2][2]),
                    arr[i - 1][2] + Math.min(dp[i - 2][0], dp[i - 2][1]));
            dp[i][1] = arr[i][1] + Math.min(arr[i - 1][0] + Math.min(dp[i - 2][1], dp[i - 2][2]),
                    arr[i - 1][2] + Math.min(dp[i - 2][0], dp[i - 2][1]));
            dp[i][2] = arr[i][2] + Math.min(arr[i - 1][0] + Math.min(dp[i - 2][1], dp[i - 2][2]),
                    arr[i - 1][1] + Math.min(dp[i - 2][0], dp[i - 2][2]));
        }

        answer = Math.min(answer, Math.min(dp[n - 1][0], dp[n - 1][2]));

        // 3번을 선택할 경우
        dp = new int[n][3];
        dp[0][0] = Integer.MAX_VALUE / 2;
        dp[0][1] = Integer.MAX_VALUE / 2;
        dp[0][2] = arr[0][2];
        dp[1][0] = dp[0][2] + arr[1][0];
        dp[1][1] = dp[0][2] + arr[1][1];
        dp[1][2] = Integer.MAX_VALUE / 2;

        for(int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(arr[i - 1][1] + Math.min(dp[i - 2][0], dp[i - 2][2]),
                    arr[i - 1][2] + Math.min(dp[i - 2][0], dp[i - 2][1]));
            dp[i][1] = arr[i][1] + Math.min(arr[i - 1][0] + Math.min(dp[i - 2][1], dp[i - 2][2]),
                    arr[i - 1][2] + Math.min(dp[i - 2][0], dp[i - 2][1]));
            dp[i][2] = arr[i][2] + Math.min(arr[i - 1][0] + Math.min(dp[i - 2][1], dp[i - 2][2]),
                    arr[i - 1][1] + Math.min(dp[i - 2][0], dp[i - 2][2]));
        }

        answer = Math.min(answer, Math.min(dp[n - 1][0], dp[n - 1][1]));


        System.out.println(answer);
    }

}
