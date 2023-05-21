import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//백준 - https://www.acmicpc.net/problem/1904 - S3
//01타일

public class Main {
    
    static Map<Integer, Long> memo = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int n = Integer.parseInt(br.readLine());

        memo.put(0, 1L);
        memo.put(1, 1L);
        long result = 1;
        for(int i = 2 ; i <= n ; i++){
            result = getOutComes(i);
        }
        System.out.println(result);
    }

    public static Long getOutComes(int i){
        memo.put(i, (memo.get(i-1)+memo.get(i-2)) % 15746);
        return memo.get(i);
    }

 
}