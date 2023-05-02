package May;
import java.util.*;

// 프로그래머스 lv2 k진수에서 소수 개수 구하기(2002 카카오 블라인드)
// https://school.programmers.co.kr/learn/courses/30/lessons/92335

public class Jaehyuck_20230502 {

	public static void main(String[] args) {
		int n = 437674;
		int k =3 ;
		
		int answer = 0;
        String [] subStr  = Integer.toString(n,k).split("0");
   
        loop : for(int i=0;i<subStr.length;i++){
  
            if(subStr[i].equals("") || subStr[i].equals("1")) continue;
            long t = Long.parseLong(subStr[i]);
            // 제곱근으로 약수구하기 
            for(long j=2;j<=Math.sqrt(t);j++){
                if(t%j == 0) continue loop;
            }
            answer++;
        }
        
        	System.out.println(answer);

	}

}
