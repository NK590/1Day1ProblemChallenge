// 백준 1826 - 연료 채우기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int answer = 0;
		int idx = 0;
		int dist = 0;
		int N = Integer.valueOf(br.readLine());
		Oil[] arr = new Oil[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int d = Integer.valueOf(str[0]);
			int o = Integer.valueOf(str[1]);

			arr[i] = new Oil(d, o);
		}

		Arrays.sort(arr);

		String[] str = br.readLine().split(" ");
		int L = Integer.valueOf(str[0]);
		int P = Integer.valueOf(str[1]);

		dist = P;

		while (dist < L) {
			while (idx < arr.length && arr[idx].d <= dist) {
				pq.add(arr[idx].o);
				idx++;
			}

			if (pq.isEmpty()) {
				answer = -1;
				break;
			}
			
			dist += pq.poll();
			answer++;
		}

		System.out.println(answer);
	}

	public static class Oil implements Comparable<Oil> {
		int d;
		int o;

		Oil(int d, int o) {
			this.d = d;
			this.o = o;
		}

		@Override
		public int compareTo(Oil o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}

}
