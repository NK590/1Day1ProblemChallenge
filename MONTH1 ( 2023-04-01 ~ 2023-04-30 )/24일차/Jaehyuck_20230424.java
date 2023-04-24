package April;
import java.util.*;
// 프로그래머스 lv2 기능개발
// https://school.programmers.co.kr/learn/courses/30/lessons/42586#
public class Jaehyuck_20230424 {

	public static void main(String[] args) {
		int [] progresses = {90,90,90,90};
		int [] speeds = {30,1,1,1};
		int[] answer = {};
		Queue<Integer> queue = new LinkedList<>();
		int c =0;
		for(int i=0;i<progresses.length;i++){
			c = 100 - progresses[i];
			if(c % speeds[i] == 0){
				c = c / speeds[i];
			}else {
				c = c / speeds[i] + 1;
			}
			queue.offer(c);
		}

		answer = new int[progresses.length];
		int n =0;
		while(!queue.isEmpty()){
			if(answer[n] == 0) {
				answer[n] =1;
				c = queue.poll();
				continue;
			}

			if(queue.peek()>c){
				n++;
				answer[n] = 1;
				c = queue.poll();
			} else {
				queue.poll();
				answer[n] = answer[n]+1;
			}
		}

		answer = Arrays.copyOf(answer, n+1);
		System.out.println(Arrays.toString(answer));

	}

}
