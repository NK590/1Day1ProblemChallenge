import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 1,000,000 이하의 소수의 개수는 약 78000
		// 총 4가지 수를 더했을 때 나오는 경우의 수는 78000^4 로 시간초과 
		
		// 골드바흐의 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 표현가능하다
		// 미리 [2, 2] or [2, 3] 를 빼서 N 을 2보다 큰 짝수로 만든 후 2가지 소수를 더했을 때 그 값이 나오는 수를 찾기 
		// 78000^2 로 계산 가

		int N = Integer.valueOf(br.readLine());
		boolean[] sieve = new boolean[10000001];
		Arrays.fill(sieve, true);

		// 가장 작은 소수인 2를 4개 더해도 8이기 때문에 8보다 작은 수는 반환할 수 없다.
		if(N < 8) {
			bw.write("-1");
		} else {
			// 짝수인 경우 2 2 출력, 홀수인 경우 2 3 출력 후 N에서 빼기 
			if(N % 2 == 0) {
				bw.write("2 2 ");
				N -= 4;
			} else if(N % 2 == 1) {
				bw.write("2 3 ");
				N -= 5;
			}
			
			// 에라토스테네스의 체로 1,000,000 이하의 소수 구하기
			for(int i = 2; i <= 500000; i++) {
				int idx = 2;
				
				while(i * idx <= 1000000) {
					sieve[i * idx] = false;
					idx++;
				}
			}
			
			// 1,000,000 이하의 소수 두 개를 조합했을 때 N 이 되는 수 찾기
			Loop1: for(int i = 2; i < sieve.length; i++) {
				if(!sieve[i])
					continue;
				for(int j = i; j < sieve.length; j++) {
					if(!sieve[j])
						continue;
					
					if(i + j == N) {
						bw.write(i + " " + j);
						break Loop1;
					}
				}
			}
		}
		
		bw.flush();
		bw.close();
	}

}
