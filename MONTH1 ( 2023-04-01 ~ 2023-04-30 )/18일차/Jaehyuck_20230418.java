package April;
//프로그래머스 lv2 JadenCase 문자열 만들기
//https://school.programmers.co.kr/learn/courses/30/lessons/12951#
public class Jaehyuck_20230418 {
	public static void main(String[] args) {
		String s = "3people unFollowed me";
		String answer = "";
        boolean flag = true;
        // 공백을 만나고 다음글자가 영어일때만 대문자치환
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                answer += s.charAt(i);
                flag = true;
            } else if(!Character.isDigit(s.charAt(i))){
                if(flag){
                   answer +=  Character.toString(s.charAt(i)).toUpperCase();
                } else {
                    answer += Character.toString(s.charAt(i)).toLowerCase();
                }
                flag = false;
            }else {
                answer += s.charAt(i);
                flag = false;
            }
        }

	}

}
