import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int C = Integer.valueOf(str[0]);
        int N = Integer.valueOf(str[1]);
        int[][] arr = new int[N][2];
        int[] dp = new int[C + 1];

        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(str[0]);
            arr[i][1] = Integer.valueOf(str[1]);
        }

        for (int i = 0; i < C; i ++) {
            for(int j = 0; j < N; j++) {
                int C2 = i + arr[j][1];
                int m = arr[j][0];

                if(C2 > C)
                    C2 = C;

                dp[C2] = Math.min(dp[C2], dp[i] + m);
            }
        }

        bw.append(dp[C] + " \n");
        bw.flush();
        bw.close();
    }

}