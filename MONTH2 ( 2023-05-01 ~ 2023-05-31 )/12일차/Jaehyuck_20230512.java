package May;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Jaehyuck_20230512{
	
	public static void migration(ArrayList<Integer> match, ArrayList<Integer> Nextmatch) {
		match.clear();
		for(int i : Nextmatch) {
			match.add(i);
		}
		Nextmatch.clear();
	}

public static void main(String[] args) throws Exception {

	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st = new StringTokenizer(br.readLine());
	  int n = Integer.parseInt(st.nextToken());
	  int k = Integer.parseInt(st.nextToken());
	  int c = Integer.parseInt(st.nextToken());
	  int cnt =0;
	  boolean flag = false;
	  ArrayList<Integer> match = new ArrayList<Integer>();
	  ArrayList<Integer> Nextmatch = new ArrayList<Integer>();
	  
	  for(int i=1;i<=n;i++) {
		  match.add(i);
	  }
	  while(match.size() != 1) {
		  cnt++;
		  for(int i=0;i<match.size();i+=2) {
			  if(i == match.size()-1) {
				  Nextmatch.add(match.get(i));
			  }
			  else if((match.get(i) == k && match.get(i+1) == c) ||(match.get(i) == c && match.get(i+1) == k)) {
				  flag = true;
				  break;
			  }
			  else if(match.get(i) == k || match.get(i+1) == k) {
				  Nextmatch.add(k);
			  }
			  else if(match.get(i) == c || match.get(i+1) == c) {
				  Nextmatch.add(c);
			  }
			  else {
				  Nextmatch.add(match.get(i));
			  }
		  }
		  if(flag) {
			  break;
		  }
		  migration(match,Nextmatch);
		  
	  }
	  System.out.println(cnt);
	  
	}
}