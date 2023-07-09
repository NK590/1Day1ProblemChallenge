import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int round =  enemy.length;
        int enemies = 0;
        int remainK = k;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < round; i++) {
            enemies += enemy[i];
            pq.add(enemy[i]);
            if(n < enemies) {
                if(remainK == 0) break;

                remainK--;
                enemies -= pq.poll();
            }

            answer++;
        }

        return answer;
    }
}