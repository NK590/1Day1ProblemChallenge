package April;
import java.util.*;
// 프로그래머스 lv2 연속 부분 수열 합의 개수 
// https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class Jaehyuck_20230415 {
	public static void main(String[] args) {
		
		int [] elements = {7,9,1,1,4};
		 int answer = 0;
	        Map<Integer,String>map = new HashMap<Integer,String>();
	        int sum =0;
	        int n =0;
	        //순환하여 수열의 합구하기 , 마지막 인덱스는 0으로 초기화하여 돌기 
	        for(int i=0;i<elements.length;i++){
	            map.put(elements[i],"");
	            sum = elements[i];
	            n = i+1;
	            if(i == elements.length-1) n =0;
	            while(n != i){
	                sum += elements[n];
	                map.put(sum,"");
	                n++;
	                if(n == elements.length) n=0;
	            
	            }
	        }
	        
	        answer = map.size();
	}

}
