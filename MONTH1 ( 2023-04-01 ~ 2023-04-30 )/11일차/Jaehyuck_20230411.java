package April;
//프로그래머스 lv2 숫자 변환하기
// https://school.programmers.co.kr/learn/courses/30/lessons/154538
public class Jaehyuck_20230411 {

	public static void main(String[] args) {
		int x =10;
		int y = 40;
		int n = 5;
		int answer = 0;
		// 값을 담을 배열 준비
        int [] dp = new int[y+1];
        //x부터 시작해서 나올수 없는수 
        for(int i = x; i<=y;i++){
            if(i != x && dp[i] == 0) {
                dp[i] = -1; 
                continue;
            }
          //경우의수가 있을경우 현재상태와 +1 한것과 전에 왔던 수를 비교
            if(i*2 <= y){
                if(dp[i*2] == 0){
                    dp[i*2] = dp[i] +1;
                } else {
                    dp[i*2] = Math.min(dp[i]+1,dp[i*2]);
                }
            }
            if(i*3 <= y){
                if(dp[i*3] == 0){
                    dp[i*3] = dp[i] +1;
                } else {
                    dp[i*3] = Math.min(dp[i]+1,dp[i*3]);
                }
            }
            if(i+n <= y){
                if(dp[i+n] == 0){
                    dp[i+n] = dp[i] +1;
                } else {
                    dp[i+n] = Math.min(dp[i]+1,dp[i+n]);
                }
            }
        }
        System.out.println(dp[y]);
    }

}


