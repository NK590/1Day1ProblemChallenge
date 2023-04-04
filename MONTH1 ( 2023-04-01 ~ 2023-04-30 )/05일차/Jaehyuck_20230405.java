package April;
//프로그래머스 -> 숫자 블 lv2
//https://school.programmers.co.kr/learn/courses/30/lessons/12923#

public class Jaehyuck_20230405 {

	public static void main(String[] args) {
		long begin = 0;
		long end = 10;
		 int [] answer = new int[(int)(end-begin+1)];
	     int j =0;
	    for (long i = begin;i<=end;i++){
	       answer[j] = Long.valueOf(block(i)).intValue();
	        j++;
	      }
	}
	public static long block(long n){
		   int answer =0;
	        if(n == 1) return 0;
	        else if(n < 4) return 1;
	        // 제곱근보다 큰약수
			for(int i = 2;i<= Math.sqrt(n);i++){
	        // 제일큰약수가 맨마지막 블럭 , 1000만 이상은 블럭이 없기 때문에 최소약수로
	            if(n % i == 0 ){
	                // 천만이상일경우 최대약수 구하기
	                if(n / i > 10000000) answer = i;
	                else return n / i;
	              } 
	            }
	        //소수는 무조건 1 리턴
			if(answer == 0) return 1;
	        else return answer;
    
    }

}
