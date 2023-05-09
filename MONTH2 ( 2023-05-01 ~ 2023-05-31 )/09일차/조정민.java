// 백준 1715 - 카드 정렬하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        PriorityQueueInteger pq = new PriorityQueue();
        int answer = 0;

        for(int i = 0; i  N; i++) {
            pq.add(Integer.valueOf(br.readLine()));
        }

        while(pq.size()  1) {
            int c = pq.poll() + pq.poll();

            answer += c;
            pq.add(c);
        }

        System.out.println(answer);
    }
}
