package May;
//프로그래머스 lv2 예상 대진표 (2017 팁스타운)
//https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class Jaehyuck_20230523 {

	public static void main(String[] args) {
			int n = 8;
			int a = 4;
			int b = 7;
			
			int answer = 0;
	        int cnt = 0;
	        while(true){
	            cnt =1;
	            for(int i=1;i<=n;i=i+2){
	                if(a == i || a == i+1){
	                  a = cnt;  
	                }
	                if(b == i || b == i+1){
	                  b = cnt;
	                }
	                if(a == b) break;
	                cnt++;
	            }
	            n = n/2;
	            answer++;
	            if(a == b) break;
	        }
	        System.out.println(answer);

	}

}
