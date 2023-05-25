// 백준 23286 - 허들 넘기

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
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.valueOf(str[0]);
        int M = Integer.valueOf(str[1]);
        int T = Integer.valueOf(str[2]);
        int[][] dist = new int[N + 1][N + 1];

        for(int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }

        for(int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.valueOf(str[0]);
            int b = Integer.valueOf(str[1]);
            int c = Integer.valueOf(str[2]);

            dist[a][b] = c;
        }

        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= N; j++) {
                for(int k = 0; k <= N; k++) {
                    if(dist[j][k] > Math.max(dist[j][i], dist[i][k])) {
                        dist[j][k] = Math.max(dist[j][i], dist[i][k]);
                    }
                }
            }
        }

        for(int i = 0; i < T; i++) {
            str = br.readLine().split(" ");
            int a = Integer.valueOf(str[0]);
            int b = Integer.valueOf(str[1]);

            if(dist[a][b] == Integer.MAX_VALUE / 2)
                bw.append(-1 + "\n");
            else
                bw.append(dist[a][b] + "\n");
        }

        bw.flush();
        bw.close();

    }
}

