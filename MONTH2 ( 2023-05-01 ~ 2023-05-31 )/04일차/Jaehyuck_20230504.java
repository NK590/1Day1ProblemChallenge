package May;
import java.util.*;
// 프로그래머스 lv2 프로세스
// https://school.programmers.co.kr/learn/courses/30/lessons/42587

public class Jaehyuck_20230504 {

	public static void main(String[] args) {
		int location =2;
		int [] priorities = {2, 1, 3, 2};
		
		int answer = 0;
        int index = 0;
        int n =-1;
        Deque <Integer> deque = new ArrayDeque <>();
		loop : while(deque.size() != priorities.length){
			for(int i=index;i<priorities.length;i++){
				if(deque.isEmpty()){
					deque.addLast(index);
					continue loop;
				}

				if(priorities[deque.peekLast()]<priorities[i]){
					deque.pollLast();
					deque.addLast(i);
					index = i;
				}

				if(i == priorities.length-1 && deque.peekLast() ==0 ){
					break;
				}
				if(i == priorities.length-1 ){
					i=-1;
				}
				if(n == i) break;
			}

			priorities[index] = 0;
			n =0;
			if(index == priorities.length-1) {
				deque.addLast(0);
				index=1;  
			} else {
				index++;
				deque.addLast(index);
				n = index-1;
			}

		}
		for(int i=0;i<priorities.length;i++){
			answer++;
			if(location == deque.peek()) break;

			deque.pollFirst();
		}
            
		System.out.println(answer);

	}

}
