// 백준 14501 - 퇴사

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		int[] days = new int[n];
		int[] benefit = new int[n];
		int[] dp = new int[n + 1];
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			days[i] = Integer.valueOf(str[0]);
			benefit[i] = Integer.valueOf(str[1]);
		}
		
		for(int i = 0; i < n; i++) {
			int day = i + days[i]; 
			
			if(day > n)
				continue;
			
			if(i != 0) {
				dp[i] = Math.max(dp[i], dp[i-1]);
			}
			
			dp[day] = Math.max(dp[day], dp[i] + benefit[i]);
		}
		
		int max = 0;
		
		for(int x : dp) {
			max = Math.max(max, x);
		}
		
		System.out.println(max);
	}
}
