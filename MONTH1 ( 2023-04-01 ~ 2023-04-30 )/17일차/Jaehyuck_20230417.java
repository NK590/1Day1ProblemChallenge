package April;

// 프로그래머스 lv2 최대값과 최소값
// https://school.programmers.co.kr/learn/courses/30/lessons/12939

public class Jaehyuck_20230417 {

	public static void main(String[] args)  {
		String s = "1 2 3 4";
		String answer = "";
        String [] splitStr = s.split(" ");
        int max = Integer.parseInt(splitStr[0]);
        int min = Integer.parseInt(splitStr[0]);
        for(int i=1; i<splitStr.length;i++){
            max = Math.max(max,Integer.parseInt(splitStr[i]));
            min = Math.min(min,Integer.parseInt(splitStr[i]));
        }
        System.out.println(min + " " + max);
       
	}
}