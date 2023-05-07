// 백준 1781 - 컵라면
// 우선순위 큐, 그리디

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		List<int[]> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			
			list.add(new int[] {a, b});
		}
		
		Collections.sort(list, (a, b) -> a[0] - b[0]);
		
		for(int[] x : list) {
			int a = x[0];
			int b = x[1];
			
			if(a > pq.size()) {
				pq.add(b);
			} else {
				if(pq.peek() < b) {
					pq.add(b);
					pq.poll();
				}
			}
		}
		
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
	}

}
