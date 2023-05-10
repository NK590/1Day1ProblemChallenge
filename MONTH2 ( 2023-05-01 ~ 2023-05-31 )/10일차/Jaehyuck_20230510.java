package May;
// 백준 lv3 수 이어 쓰기 (1515) 
// https://www.acmicpc.net/problem/1515
import java.util.*;

public class Jaehyuck_20230510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Queue<String> que = new LinkedList<>();
		for(int i=0;i<str.length();i++) {
			que.offer(Character.toString(str.charAt(i)));
		}
		int i =0;
		while(!que.isEmpty()) {
			i++;
			str = Integer.toString(i);
			if(str.contains(que.peek())) {


			for(int j=0;j<str.length();j++) {
				if(que.isEmpty()) {
					break;
				} else if(que.peek().equals(Character.toString(str.charAt(j)))) {
					que.poll();
				}
			  }
			}
			
		}
		System.out.println(i);
	
	
	}

}