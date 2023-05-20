package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 백준 silver level5 덩치 (7568)
// https://www.acmicpc.net/problem/7568
public class Jaehyuck_20230520 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		int [][] arr = new int[n][2];
		StringBuilder sb = new StringBuilder();
		int x =0;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<arr.length;i++) {
			x =1;
			for(int j=0;j<arr.length;j++) {
				if(i == j) continue;
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) {
					x++;
				}
			}
			sb.append(x + " ");
		}
		System.out.println(sb.toString());
	}

}
