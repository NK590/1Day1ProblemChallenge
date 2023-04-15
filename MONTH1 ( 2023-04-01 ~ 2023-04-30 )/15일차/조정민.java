// 프로그래머스 - 가장 큰 수

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] number = new String[numbers.length];
        boolean flag = true;
        
        for(int i = 0; i < numbers.length; i++) {
            number[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(number, (a, b) -> {                
                    int x = Integer.valueOf(a + b);
                    int y = Integer.valueOf(b + a);                    

                    return y - x;
            }
        );
        
        StringBuilder sb = new StringBuilder();
        
        for(String x : number) {
            sb.append(x);
        }
        
        if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}
