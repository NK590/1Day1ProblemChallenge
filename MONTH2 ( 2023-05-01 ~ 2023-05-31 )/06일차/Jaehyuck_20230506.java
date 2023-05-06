package May;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 백준 silver lv4 제로
// https://www.acmicpc.net/problem/10773
public class Jaehyuck_20230506 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int n =0;
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<cnt;i++) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) stack.pop();
			else {
				stack.push(n);
			}
		}
		n=0;
		if(!stack.isEmpty()) {
			for(int x : stack) {
				n+= x;
			}
		} 
			System.out.println(n);
		

	}

}
