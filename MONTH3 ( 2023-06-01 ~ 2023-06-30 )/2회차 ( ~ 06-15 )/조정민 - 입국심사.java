import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 입국심사를 확실히 다 끝낼 수 있는 시간을 찾은 후
        // 그 값을 기준으로 이분탐색으로 시간을 줄여가면서 입국 심사를 다 끝낼 수 있는 최소 시간을 찾는다.
        // left = 0, right = 입국심사에 걸리는 시간이 가장 짧은 사람이 n 명을 입국심사 하는데 걸리는 시간
     	Arrays.sort(times);

		long answer = 0;
        long left = 0;
		long right = (long)n * (long)times[0];
        long mid = right / 2;
        
		while (left + 1 < right) {
            long cnt = 0;
            
            for(int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }
            
            if(cnt >= n) {
                // 심사 가능한 사람의 수가 목표 값 이상일 경우
                // right = mid
                // mid = (right + left) / 2
                right = mid;
                mid = (right + left) % 2 == 0 ? (right + left) / 2 : (right + left) / 2 + 1; 
            } else {
                // 심사 가능한 사람의 수가 목표 값 이하일 경우
                // left = mid
                // mid = (right + left) / 2
                left = mid;
                mid = (right + left) % 2 == 0 ? (right + left) / 2 : (right + left) / 2 + 1;    
            }
            
        }
        
		return mid;
	}
}
