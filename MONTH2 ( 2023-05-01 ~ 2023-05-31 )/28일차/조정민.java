// 백준 11054 - 가장 긴 바이토닉 부분 수열

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n + 2];
        int[] dp = new int[n + 2];
        int[] dp2 = new int[n + 2];
        String[] str = br.readLine().split(" ");

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.valueOf(str[i - 1]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j]);
            }

            dp[i] += 1;
        }

        for(int i = n ; i > 0; i--) {
            for(int j = n + 1; j > i; j--) {
                if(arr[i] > arr[j])
                    dp2[i] = Math.max(dp2[i], dp2[j]);
            }

            dp2[i] += 1;
        }

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            answer = Math.max(dp[i] + dp2[i], answer);
        }

        bw.append(answer - 1 + "\n");
        bw.flush();
        bw.close();
    }

}
