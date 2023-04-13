package April;

// 프로그래머스 연속된 부분 수열의 합 lv2
// https://school.programmers.co.kr/learn/courses/30/lessons/178870

import java.util.*;
public class Jaehyuck_20230414 {

	public static void main(String[] args) {
		int[] answer = new int[2];
		int [] sequence = {1, 2, 3, 4, 5};
		int k = 7;
        Queue<Integer> que = new LinkedList<Integer>();
        int sum =0;
        // 시퀀스 의 촐합이 k와같을수 있기때문에 +1 
        int size =sequence.length+1;
        // 큐에 인덱스 값을 저장하며 k랑 같은 수열찾기
        for(int i=0;i<sequence.length;i++){
           sum += sequence[i];
            que.offer(i);               
        
            // 합 이 k 에 맞는 수열까지 앞 인덱스 제거
            if(sum > k){      
             while(sum >k){
                sum -= sequence[que.peek()];
                que.poll();
             		}
            	} 
            // 수열을 찾을 경우 길이를 비교해 작은 수열의 인덱스 저장 
            if(sum == k){   
                if(que.size() < size){
                    size = que.size();
                    answer[0] = que.peek();
                    answer[1] = i;
                	}
            	}     

        	}
        System.out.println(answer);
 
	}

}
