// 프로그래머스 - 연속된 부분 수열의 합

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = null;
        
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while(end <= sequence.length) {
            if(sum < k) {
                if(end == sequence.length)
                    break;
                
                sum += sequence[end++];
            } else if(sum > k) {
                sum -= sequence[start++];
            } else if(sum == k) {
                if(answer == null || (answer[1] - answer[0] > end - start - 1)) {
                    answer = new int[] {start, end - 1};
                }
                
                if(end == sequence.length)
                    break;
                
                sum -= sequence[start++];
                sum += sequence[end++];
            }
        }
        
        System.out.println(sum);
            
        return answer;
    }
}
