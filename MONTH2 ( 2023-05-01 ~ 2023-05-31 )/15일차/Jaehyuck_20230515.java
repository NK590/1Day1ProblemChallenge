package May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Jaehyuck_20230515 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> set = new TreeSet<Integer>();
		StringBuilder st = new StringBuilder();
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		List<Integer> arr = new ArrayList<>(set);
		Collections.sort(arr);
		for(int i=0;i<arr.size();i++) {
			st.append(arr.get(i)+"\n");
		}
		
		System.out.println(st.toString());
	}

}
