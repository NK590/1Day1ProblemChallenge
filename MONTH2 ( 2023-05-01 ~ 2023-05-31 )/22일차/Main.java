import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//백준 - https://www.acmicpc.net/problem/9461 - S3
//파도반 수열

public class Main {
    
    static Map<Integer, Long> memo = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String sCnt = br.readLine();
        int cnt = Integer.parseInt(sCnt);
        
        memo.put(0, 1L);
        memo.put(1, 1L);
        memo.put(2, 1L);
        memo.put(3, 2L);
        memo.put(4, 2L);
        while(cnt > 0){
            int n = Integer.parseInt(br.readLine());
            long result = 1;
            n--;
            cnt--;
            if(n < 5){
                System.out.println(memo.get(n));
                continue;
            }
            for(int i = 5 ; i <= n ; i++){
                result = getFibonacci(i);
            }
            System.out.println(result);

        }
    }
    //n번째 숫자 출력
    public static Long getFibonacci(int i){
        long result = memo.get(i-2) + (memo.get(i-1) - memo.get(i-4));
        memo.put(i, result);
        return memo.get(i);
    }

 
}