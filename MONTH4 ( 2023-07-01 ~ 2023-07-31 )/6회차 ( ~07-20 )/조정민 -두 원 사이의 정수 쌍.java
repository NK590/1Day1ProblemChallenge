import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        int x = 0;

        while(x < r2) {
            if(x < r1) {
                int p1 = (int) Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
                int p2 = (int) Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
                answer += p2 - p1;

                // p1 의 값이 정수라면 점 추가
                if(p1 == Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)))
                    answer++;
            } else {
                answer += (int) Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            }
            x++;
        }
        System.out.println(answer);
        answer *= 4;

        return answer;
    }
}