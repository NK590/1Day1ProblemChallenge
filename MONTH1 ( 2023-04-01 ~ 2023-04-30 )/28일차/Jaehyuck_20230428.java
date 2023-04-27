package April;
import java.util.*;

// 프로그래머스 lv_2 튜플 (2019 카카오 겨울 인텁쉽)
// https://school.programmers.co.kr/learn/courses/30/lessons/64065

public class Jaehyuck_20230428 {

	public static void main(String[] args) {
		int [] answer = {};
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        // 원소끼리 나누기 위해 원소앞 { 를 뺴고 공백으로 다치환
        s = s.replaceAll("\\{\\{","\\{").replaceAll("\\}","");
        // 원소끼리 나눔
        String [] splitStr = s.split("\\{");
        
        Queue<String> que = new LinkedList<>();
        // 원소의 길이대로 정렬 
        Arrays.sort(splitStr, (String s1, String s2) -> s1.length() - s2.length());
      
        for(int i=1;i<splitStr.length;i++){
        	// 원소 안에 값들 나누
            String [] subStr = splitStr[i].split(",");
            // 큐안에 없는 원소 넣기 ( 길이대로 정렬 했기 때문에 최대1개밖에 나올수없음) 
            if(que.isEmpty()){
              que.offer(subStr[0]);
            } else {
              for(int j=0;j<subStr.length;j++){
                  if(!que.contains(subStr[j])){
                      que.offer(subStr[j]);
                      break;
                  }
              }  
            }
        }
        
        answer = new int[que.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = Integer.parseInt(que.poll());
        }
       System.out.println(answer);

	}

}
