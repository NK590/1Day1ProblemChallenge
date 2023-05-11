// 백준 9251 - LCS

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
    static List<List<int[]>> graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();

        String[] str = new String[a.length() + 1];
        String[] str2 = new String[b.length() + 1];

        for(int i = 0; i < a.length(); i++) {
            str[i + 1] = String.valueOf(a.charAt(i));
        }

        for(int i = 0; i < b.length(); i++) {
            str2[i + 1] = String.valueOf(b.charAt(i));
        }

        int aSize = str.length;
        int bSize = str2.length;
        int[][] dp = new int[aSize][bSize];
        int answer = 0;

        for (int i = 0; i < aSize; i++) {
            for (int j = 0; j < bSize; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str[i].equals(str2[j])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < aSize; i++) {
            for (int j = 0; j < bSize; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }


        bw.append(answer + "\n");
        bw.flush();
        bw.close();
    }

}
