package May;

// 프로그래머스 lv2 숫자의표현
// https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class Jaehyuck_20230503 {

	public static void main(String[] args) {
		int n = 15;
		int answer = 0;
        int c =0;
        for(int i=1;i<=n/2;i++){
            for(int j=i;j<=n/2+1;j++){
                c += j;
                if(c > n){
                    break;
                }
                else if(c == n ){
                    answer++;
                    break;
                }
            }
            c =0;
        }
        
        System.out.println(answer);

	}

}
