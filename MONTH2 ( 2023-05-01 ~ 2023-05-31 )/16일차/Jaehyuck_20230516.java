package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 silver lv4 수찾기 (1920)
// https://www.acmicpc.net/problem/1920
public class Jaehyuck_20230516 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		StringBuilder st = new StringBuilder();
		StringTokenizer stn = new StringTokenizer(br.readLine());
		Map<String,Integer> map = new HashMap<>();
		String str ="";
		for(int i=0;i<n;i++) {
			str = stn.nextToken();
			if(!map.containsKey(str)) {
				map.put(str, 1);
			}
		}

		int m = Integer.parseInt(br.readLine());
		stn =  new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) {
			str = stn.nextToken();
			if(map.containsKey(str)) st.append(1+"\n");
			else st.append(0+"\n");
		}


		System.out.println(st.toString());
	}

}
