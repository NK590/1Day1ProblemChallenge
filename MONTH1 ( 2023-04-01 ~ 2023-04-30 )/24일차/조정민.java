// 백준 - 용액

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int min = Integer.MAX_VALUE;
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];
		int[] answer = new int[2];
		String[] str = br.readLine().split(" ");

		int left = 0;
		int right = n - 1;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}

		while (left < right) {
			int num = arr[left] + arr[right];

			if(min >= Math.abs(num)) {
				min = Math.abs(num);
				answer[0] = left;
				answer[1] = right;
			}

			if(num > 0)
				right--;
			else if(num < 0)
				left++;
			else
				break;
		}

		System.out.println(arr[answer[0]] + " " + arr[answer[1]]);
	}
}
