// 백준 - RGB 거리

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.valueOf(bf.readLine());		
		
		String[] prev = null;
		String[] now = null;
		
		prev = bf.readLine().split(" ");
		
		for(int i = 1; i < cnt; i++) {
			now = bf.readLine().split(" ");
			prev = fn(prev, now);	
		}
		
		int prev_1 = Integer.valueOf(prev[0]);
		int prev_2 = Integer.valueOf(prev[1]);
		int prev_3 = Integer.valueOf(prev[2]);
		
		String answer = "" + Math.min(Math.min(prev_1, prev_2), prev_3);
		
		bw.write(answer);
		bw.flush();
		bw.close();

	}
	
	public static String[]  fn(String[] prev, String[] now) {
		
		String[] result = new String[3]; 
		
		int prev_1 = Integer.valueOf(prev[0]);
		int prev_2 = Integer.valueOf(prev[1]);
		int prev_3 = Integer.valueOf(prev[2]);

		int now_1 = Integer.valueOf(now[0]);
		int now_2 = Integer.valueOf(now[1]);
		int now_3 = Integer.valueOf(now[2]);
		
		result[0] = "" + Math.min(now_1+prev_2, now_1+prev_3);
		result[1] = "" + Math.min(now_2+prev_1, now_2+prev_3);
		result[2] = "" + Math.min(now_3+prev_1, now_3+prev_2);
		
		
		
		return result;
	}

}
