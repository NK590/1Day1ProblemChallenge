package April;
// 프로그래머스 lv2 124 나라의 숫자
// https://school.programmers.co.kr/learn/courses/30/lessons/12899 
public class Jaehyuck_20230422 {

	public static void main(String[] args) {
		int n =4;
		String answer = "";
        int c = 0;
        while(n>0){
            c = n%3;
            if(c == 0) {
                answer = "4"+answer;
                n = n/3 -1;
            }else {
                answer = Integer.toString(c) + answer;
             n = n/3 ;
        }
    }
    System.out.println(answer);
	}

}
