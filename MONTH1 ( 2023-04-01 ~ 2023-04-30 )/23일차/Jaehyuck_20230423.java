package April;
// 프로그래머스 lv2 다음 큰 숫자
// https://school.programmers.co.kr/learn/courses/30/lessons/12911

public class Jaehyuck_20230423 {

	public static void main(String[] args) {
		int n =78;
		int answer = 0;
		// 2진수로 변환해 1의 갯수를 샌다 
        int c = Integer.bitCount(n);
        // 1씩증가시켜 1의갯수가 같은 수를 만났을때 break
        while(true){
             n++;
            if(c == Integer.bitCount(n)){
                answer = n;
                break;
            }
            
        }
        System.out.println(answer);

	}

}
