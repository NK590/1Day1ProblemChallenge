// 백준 1717 - 집합의 표현

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(str.nextToken());
		int m = Integer.valueOf(str.nextToken());
		
		parent = new int[n + 1];
		
		for(int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		
		while(m-- > 0) {
            str = new StringTokenizer(br.readLine());
            int c = Integer.valueOf(str.nextToken());
            int a = Integer.valueOf(str.nextToken());
            int b = Integer.valueOf(str.nextToken());
			
			if(c == 0) {
				union(a, b);
			} else if(c == 1) {
				if(find(a) == find(b)) {
					bw.append("YES");
				} else {
					bw.append("NO");
				}
				bw.append("\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

	public static int find(int a) {
		if(parent[a] == a)
			return a;
		
		return find(parent[a]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
        if(a != b)
    		parent[b] = a;
	}

}
