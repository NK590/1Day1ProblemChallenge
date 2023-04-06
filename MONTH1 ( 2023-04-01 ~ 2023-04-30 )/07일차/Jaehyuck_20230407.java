package April;
// 프로그래머스 큰수 만들기 lv2 
// https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class Jaehyuck_20230407 {

	public static void main(String[] args) {
		String word = "AAAE";
		  int answer = 0;
	        char splitWord =' ';
	        
	        //총경우의수 5 25 125 625 3125 = 3905
	        // 781 + 312 + 93
	        int total = 3905;
	       
	        for(int i=1;i<=word.length();i++){
	            splitWord = word.charAt(i-1);
	            // 각 자리별로 경우의수를 구한뒤 자릿수 계산을 위한 +1
	            if(splitWord == 'A') answer++;
	            else if(splitWord == 'E') answer += ((int)total/Math.pow(5,i))+1;
	            else if(splitWord == 'I') answer += ((int)total/Math.pow(5,i))*2+1;
	            else if(splitWord == 'O') answer += ((int)total/Math.pow(5,i))*3+1;
	            else if(splitWord == 'U') answer += ((int)total/Math.pow(5,i))*4+1;
	            total -= Math.pow(5,i);
	        }
            System.out.println(answer);
        

	}

}
