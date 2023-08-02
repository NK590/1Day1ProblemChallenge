package August;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class 백준_칸토어집합_1w {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder answer ;
		int n =0;
		while((str = br.readLine()) != null) {
			n = Integer.parseInt(str);
			answer  = new StringBuilder();
			int len = (int) Math.pow(3, n);
			for(int i=0;i<len;i++) {
				answer.append("-");
			}
			makeLine(0,len,answer);
			System.out.println(answer);
		}
	}
	
	public static StringBuilder makeLine(int start,int size,StringBuilder answer) {
		if(size == 1) return answer;
		int newSize = size/3;
		for(int i = start+newSize;i< start+(newSize*2);i++){
			answer.setCharAt(i, ' ');
		}
		makeLine(start, newSize,answer); 
		makeLine(start+2*newSize, newSize,answer); 
		return answer;
	}

}
