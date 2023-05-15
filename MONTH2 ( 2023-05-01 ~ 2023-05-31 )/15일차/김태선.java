import java.io.BufferedReader;
import java.io.InputStreamReader;


//백준 - https://www.acmicpc.net/problem/1193 - 분수찾기 S5

public class Main {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int findNumber = Integer.parseInt(br.readLine());

        int n = 1;
        int sum = 1;
        while(true){
            if(sum >= findNumber){
                sum -= n;
                break;
            }
            n++;
            sum += n;
        }
        int gap = findNumber - sum;
        if((n & 1) == 0) System.out.println(gap + "/" + (n+1 - gap));
        else System.out.println((n+1 - gap) + "/" +gap);
    }

}