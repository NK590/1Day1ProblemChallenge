import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long limit = (long) Math.pow(d, 2);
        int a = 0;

        while(true) {
            boolean flag = false;

            if(limit < Math.pow(a * k, 2))
                break;

            long cnt = (long) Math.sqrt(limit - Math.pow(a * k, 2)) / k;
            answer += cnt + 1;

            a++;
        }

        return answer;
    }
}