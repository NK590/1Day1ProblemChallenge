import java.io.*;
import java.util.Arrays;
import java.util.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        String[] str = br.readLine().split(" ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(str[i]);
        }

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            int num = arr[i];

            while(!stack.isEmpty()) {
                int[] temp = stack.peek();

                if(temp[1] < num) {
                    stack.pop();
                    answer[temp[0]] = num;
                } else {
                    break;
                }
            }

            stack.add(new int[] {i, num});
        }

        while(!stack.isEmpty()) {
            int[] temp = stack.pop();
            answer[temp[0]] = -1;
        }

        for(int i = 0; i < n; i++) {
            bw.append(answer[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}