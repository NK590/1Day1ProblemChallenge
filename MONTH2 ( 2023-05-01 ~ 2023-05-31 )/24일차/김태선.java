import java.io.BufferedReader;
import java.io.InputStreamReader;


//백준 https://www.acmicpc.net/problem/1149 RGB거리 S1

public class Main {
    
    static int memo [][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String sCnt = br.readLine();
        int cnt = Integer.parseInt(sCnt);
        
        memo = new int [cnt+1][3];
        int result = 0;
        memo[0] = parseArray(br.readLine());

        for(int i = 1 ; i <= cnt ; i++){
            int RGB [];
            if(i != cnt) {
                RGB = parseArray(br.readLine());
            }else {
                RGB = new int [3];
            }
            doMemo(RGB, i);
        }
        cnt--;
        if(memo[cnt][0] <= memo[cnt][1] && memo[cnt][0] <= memo[cnt][2]) result = memo[cnt][0];
        if(memo[cnt][1] <= memo[cnt][0] && memo[cnt][1] <= memo[cnt][2]) result = memo[cnt][1];
        if(memo[cnt][2] <= memo[cnt][0] && memo[cnt][2] <= memo[cnt][1]) result = memo[cnt][2];


        System.out.println(result);

    }
    public static void doMemo(int a [], int n){
        if(memo[n-1][1] < memo[n-1][2]) memo[n][0] = memo[n-1][1] + a[0];
        else memo[n][0] = memo[n-1][2] + a[0];

        if(memo[n-1][0] < memo[n-1][2]) memo[n][1] = memo[n-1][0] + a[1];
        else memo[n][1] = memo[n-1][2] + a[1];

        if(memo[n-1][0] < memo[n-1][1]) memo[n][2] = memo[n-1][0] + a[2];
        else memo[n][2] = memo[n-1][1] + a[2];
    }
    public static int [] parseArray(String numbers){
        String temp[] = numbers.split(" ");
        int result [] = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2])};
        return result;
    }
}