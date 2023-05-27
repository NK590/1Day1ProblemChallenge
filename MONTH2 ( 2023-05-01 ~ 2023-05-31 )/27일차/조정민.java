// 백준 2565 - 전깃줄

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int[][] arr = new int[n][2];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int a = Integer.valueOf(str[0]);
            int b = Integer.valueOf(str[1]);

            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < n; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(arr[j][1] < arr[i][1]) max = Math.max(max, dp[j] + 1);
            }

            dp[i] = max;
        }

        int max = 0;

        for(int x :dp) {
            max = Math.max(max, x);
        }

        bw.append(n - max + "\n");
        bw.flush();
        bw.close();
    }

}
