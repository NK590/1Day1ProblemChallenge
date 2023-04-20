import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.valueOf(br.readLine());

		String[][] node = new String[n][3];

		for(int i = 0; i < n; i++) {
			node[i] = br.readLine().split(" ");
		}

		for(String[] x : node) {
			for(String y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

		// 전위
		pre(node, node[0][0]);
		bw.append("\n");
		bw.flush();

		// 후위
		mid(node, node[0][0]);
		bw.append("\n");
		bw.flush();

		// 중위
		post(node, node[0][0]);
		bw.append("\n");
		bw.flush();

		bw.close();
	}

	public static void pre(String[][] node, String value) throws IOException {
		if(value.equals("."))
			return;

		for(String[] x : node) {
			if(x[0].equals(value)) {
				bw.append(x[0]);
				pre(node, x[1]);
				pre(node, x[2]);
			}
		}

	}

	public static void mid(String[][] node, String value) throws IOException {
		if(value.equals("."))
			return;

		for(String[] x : node) {
			if(x[0].equals(value)) {
				mid(node, x[1]);
				bw.append(x[0]);
				mid(node, x[2]);
			}
		}
	}

	public static void post(String[][] node, String value) throws IOException {
		if(value.equals("."))
			return;

		for(String[] x : node) {
			if(x[0].equals(value)) {
				post(node, x[1]);
				post(node, x[2]);
				bw.append(x[0]);
			}
		}
	}

}
