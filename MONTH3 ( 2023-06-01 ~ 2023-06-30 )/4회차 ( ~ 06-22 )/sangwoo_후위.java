package examplenote;

import java.io.*;
import java.util.Stack;

public class Example_baek_1918_ {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder strBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();


        char[] charArr = br.readLine().toCharArray();

        for(char s : charArr){

            char tmpChar = ' ';
            if(!stack.isEmpty()) tmpChar = stack.peek();

            if(Character.isAlphabetic(s)){
                strBuilder.append(s);
            }else if(s == '+' || s == '-'){
                if(tmpChar != ' ' && (tmpChar =='*' || tmpChar == '/')) {
                    strBuilder.append(stack.pop());
                    strBuilder.append(stack.pop());
                }
                stack.push(s);

            }else if(s == '*' || s == '/'){
                if(tmpChar != '+' && tmpChar != '-' && tmpChar != ' '){
                    strBuilder.append(stack.pop());
                }
                stack.push(s);

            }else if(s == '('){
                stack.push(s);
            }else if(s == ')'){
                while(!stack.isEmpty()){
                    if(stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    strBuilder.append(stack.pop());
                }
            }
        }
        while(!stack.isEmpty()){
            strBuilder.append(stack.pop());
        }

        System.out.println(strBuilder.toString());

        bw.write(strBuilder.toString());
        bw.flush();
        bw.close();

    }


}
