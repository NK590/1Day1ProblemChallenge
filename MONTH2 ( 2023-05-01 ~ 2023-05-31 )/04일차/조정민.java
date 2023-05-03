// 백준 - 강의실

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		int[][] arr = new int[n][3];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
		
		int answer = 0;
		int time = 0;
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.valueOf(str[0]);
			int b = Integer.valueOf(str[1]);
			int c = Integer.valueOf(str[2]);
			
			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = c;
		}
		
		Arrays.sort(arr, (a, b) -> a[1] - b[1]);
		
		
		for(int[] x : arr) {
			time = x[1];
			
			while(!pq.isEmpty() && pq.peek()[2] <= time)
				pq.poll();
			
			pq.add(x);
			
			answer = Math.max(answer, pq.size());
		}
		
		bw.append(answer+"\n");
		bw.flush();
		bw.close();
	}
}
