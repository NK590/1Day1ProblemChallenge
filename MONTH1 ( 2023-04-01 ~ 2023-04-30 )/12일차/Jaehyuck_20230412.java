package April;
// 프로그래머스 lv2 이진 변환 반복하기
// https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Jaehyuck_20230412 {

	public static void main(String[] args) {
		 
		String s = "110010101001";
		 int[] answer = new int[2];
	     int n = 0;
	     // 0의 갯수 저장 후 0제거후 길이를 다시2진법으로 바꿔 무한반
	     while(!s.equals("1")){
	       answer[1] += s.length() - s.replace("0", "").length();
	       s = s.replaceAll("0","");
	       answer[0] += 1;
           s = Integer.toBinaryString(s.length());
	     }
	     System.out.println(answer);

	}

}
