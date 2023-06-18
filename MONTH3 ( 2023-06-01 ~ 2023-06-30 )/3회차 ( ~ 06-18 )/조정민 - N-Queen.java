import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int n) {
        int[][] field  = new int[n][n];

        fn(n, 0, 0, field);

        return answer;
    }

    public void fn(int n, int x, int cnt, int[][] field) {
        if(cnt == n)
            answer++;

        if(x == n)
            return;

        Loop1 : for(int i = 0; i < n; i++) {
            // field[x, i] 에 퀸을 놓을 수 있는 지 검사
            int c = 1;
            for(int j = x - 1; j >= 0; j--) {
                // 왼쪽 대각선 위
                if(i >= c && field[j][i - c] == 1)
                    continue Loop1;
                // 위
                if(field[j][i] == 1)
                    continue Loop1;
                // 오른쪽 대각선 위
                if(i + c < n && field[j][i + c] == 1) {
                    continue Loop1;
                }

                c++;
            }

            // 놓을 수 있는 경우
            field[x][i] = 1;
            fn(n, x + 1, cnt + 1, field);
            field[x][i] = 0;
        }
    }
}
