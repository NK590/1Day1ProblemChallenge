import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i = 0; i < s.length(); i++) {
            int cnt = 1;

            // 홀수
            while(i - cnt >= 0 && i + cnt < s.length() && s.charAt(i - cnt) == s.charAt(i + cnt)) {
                cnt++;
            }

            answer = Math.max(answer, cnt * 2 - 1);


            cnt = 1;
            // 짝수
            while(i - cnt + 1 >= 0 && i + cnt < s.length() && s.charAt(i - cnt + 1) == s.charAt(i + cnt)) {
                cnt++;
            }

            answer = Math.max(answer, (cnt - 1) * 2);
        }

        return answer;
    }
}