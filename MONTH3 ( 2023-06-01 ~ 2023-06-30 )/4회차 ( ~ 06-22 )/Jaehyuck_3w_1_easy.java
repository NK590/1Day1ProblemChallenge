package June;
import java.util.*;
import java.util.Scanner;

public class Jaehyuck_3w_1_easy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Queue<String> que = new LinkedList<>();
		for(int i=0;i<str.length();i++) {
			que.offer(Character.toString(str.charAt(i)));
		}
		String substr ="";
	//	System.out.print(que);
		int i =0;
		while(!que.isEmpty()) {
			i++;
			str = Integer.toString(i);
			if(str.contains(que.peek())) {
				substr = que.poll();
				while(!que.isEmpty()) {
					substr += que.peek();
					if(str.contains(substr)) {
						que.poll();
					} else {
						break;
					}
				}
			}
			
		}
		System.out.print(i);
		

	}

}
