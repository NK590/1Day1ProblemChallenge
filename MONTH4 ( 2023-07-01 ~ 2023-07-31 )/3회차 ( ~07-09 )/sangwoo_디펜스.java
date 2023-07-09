package examplenote;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Example142085_ {

    public static void main(String[] args) {

        int n = 7;
        int k = 3;
        int[] enemy = {4,2,4,5,3,3,1};
        System.out.println(solution(n,k,enemy));

    }

    public static int solution(int n , int k, int[] enemy){

        int answer = enemy.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int my = n;
        int card = k;
        for (int i = 0; i < enemy.length; i++) {
            my -= enemy[i];
            pq.add(enemy[i]);

            if (my < 0) {
                if (card > 0 && !pq.isEmpty()) {
                    my += pq.poll();
                    card--;
                } else {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
