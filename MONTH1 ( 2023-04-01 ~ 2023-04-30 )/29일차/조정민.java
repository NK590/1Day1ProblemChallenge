// 백준 2512 - 예산

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.valueOf(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[size];
		int money = Integer.valueOf(br.readLine());
		
		int answer = 0;
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
//			System.out.println("cost = " + arr[i] + " money = " + money);
			if(arr[i] * size <= money) {
				answer = arr[i];
				money -= arr[i];
				size--;
			} else {
				answer = money /size;
				break;
			}
		}
		
		System.out.println(answer);
		
	}
	
}
