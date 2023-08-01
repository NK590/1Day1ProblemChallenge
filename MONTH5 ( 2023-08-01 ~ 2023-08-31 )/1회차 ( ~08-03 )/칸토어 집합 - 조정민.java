import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = null;

		while((input = br.readLine()) != null) {
			int num = Integer.valueOf(input);

			bw.append(fn(num, "-") + "\n");
		}


		bw.flush();
		bw.close();

	}

	public static String fn(int n, String mark) {
		if(n == 0)
			return mark;

		if(mark.equals(" "))
			return fn(n - 1, " ") + fn(n - 1, " ") + fn(n - 1, " ");
		else
			return fn(n - 1, "-") + fn(n - 1, " ") + fn(n - 1, "-");
	}


}
