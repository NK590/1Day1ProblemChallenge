// 프로그래머스 - 혼자 놀기의 달인

class Solution {
    public int solution(int[] cards) {
        int answer = 0;                
        
        for(int i = 0; i < cards.length; i++) {
            boolean[] open = new boolean[cards.length];
        
            for(int j = 0; j < open.length; j++) {
                open[j] = false;
            }
            
            int a = fn(cards, i + 1, open);
            for(int j = 0; j < open.length; j++) {
                if(open[j] == false) {
                    int b = fn(cards, j + 1, open);
                    if(answer < a * b)
                        answer = a * b;
                }
            }
        }
        
        return answer;
    }
    
    public int fn(int[] cards, int n, boolean[] open) {
        int cnt = 0;
        
        while(true) {
            n = cards[n -1];
            
            if(open[n - 1] == true)
                break;
            
            open[n - 1] = true;
            cnt++;
        }
        
        return cnt;
    }
}
