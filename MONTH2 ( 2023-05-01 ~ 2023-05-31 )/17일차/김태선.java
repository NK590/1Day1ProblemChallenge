import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 - 다이나믹이 뭐에요 ? https://www.acmicpc.net/problem/14494 S3

public class Main {
    
    static long memo [][];
    static int n, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String command = br.readLine();
        n = Integer.parseInt(command.split(" ")[0]);
        m = Integer.parseInt(command.split(" ")[1]);
        memo = new long[n][m];
        memo[0][0] = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 && j == 0 ) continue;
                memo[i][j] = 0;
                setPassCount(i, j);
            }
        }
        
        System.out.println(memo[n-1][m-1]);
    }

    public static void setPassCount(int x, int y){
        long result = 0;
        if(x == 0){
            result += memo[x][y-1];
        }else if(y == 0){
            result += memo[x-1][y];
        }else{
            result += memo[x-1][y-1];
            result += memo[x-1][y];
            result += memo[x][y-1];
        }
        memo[x][y] = result % 1000000007;
    }
}