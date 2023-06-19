import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        String[] str = br.readLine().split("");

        // 피연산자는 그대로 입력
        // 연산자는 우선순위에 따라 +, - 는 스택에 넣은 후 다음에 오는 연산자가 +, - 일 때 출력
        // *, / 는 다음 피연사자 출력 후 바로 출력
        // 괄호가 끌날 때는 괄호 안에 있는 모든 피연산자와 연산자 출력 후 다음 연산자에 따라 위의 동작 반복

        // 참고 테스트 케이스
        // A+(C-N*(U-O)+Q)
        // AB*C+D+EF*G*+E+
        // A*B+C+D+E*F*G+E
        // ACNUO-*-Q++


        for(int i = 0; i < str.length; i++) {
            String x = str[i];
            stack.add(x);

            switch(x) {
                case "+" :
                case "-" :

                    break;

                case "*" :
                case "/" :

                    break;

                case "(" :

                    break;

                case ")" :
                    // 괄호 안의 모든 연산자를 출력
                    stack.pop();

                    while(!stack.isEmpty()) {
                        String y = stack.pop();

                        if(y.equals("("))
                            break;

                        sb.append(y);
                    }

                    while(!stack.isEmpty() && (
                            !stack.peek().equals("(")
                                    && (i == str.length - 1 || (!str[i+1].equals("*") && !str[i+1].equals("/")))
                                    || stack.peek().equals("*")
                                    || stack.peek().equals("/"))) {
                        sb.append(stack.pop());
                    }

                    break;

                default :
                    sb.append(stack.pop());

                    while(!stack.isEmpty() && (
                            !stack.peek().equals("(")
                                    && (i == str.length - 1 || (!str[i+1].equals("*") && !str[i+1].equals("/")))
                                    || stack.peek().equals("*")
                                    || stack.peek().equals("/"))) {
                        sb.append(stack.pop());
                    }
                    break;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

