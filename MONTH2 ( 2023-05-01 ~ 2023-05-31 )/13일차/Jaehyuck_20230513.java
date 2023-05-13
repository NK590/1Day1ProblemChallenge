package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 백준 silver lv4 나는야 포켓 마스터 이다솜 (1620)
// https://www.acmicpc.net/problem/1620

public class Jaehyuck_20230513 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		Map<String,Integer> map = new HashMap<String,Integer>();
		String[] arr = new String[k+1];
		String poketmon = "";
		for(int i=0;i<k;i++) {
			poketmon = br.readLine();
			map.put(poketmon,i+1);
			 arr[i] = poketmon;
		}
		k =  Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {

			String str = br.readLine();
			int c = (int) str.charAt(0);
			// 숫자가 아니라면
			if ( c< 48 || c > 57) {
				System.out.println(map.get(str));

			} else {
				System.out.println(arr[Integer.parseInt(str)-1]);
			}

		}


	}

}