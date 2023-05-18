import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    
    static Map<String, Integer> memo = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String line;
         while((line = br.readLine()) != null){
                 if("-1 -1 -1".equals(line)) break;
            String numbers [] = line.split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);
            int c = Integer.parseInt(numbers[2]);
            
            System.out.println("w("+a+", "+b+", "+c+") = "+recursion(a, b, c));

         }

    }

    public static int recursion(int a, int b, int c){
        if(a <= 20 && b <= 20 && c <= 20 && memo.get(a+"|"+b+"|"+c) != null){
            return memo.get(a+"|"+b+"|"+c);
        }
        if(a <= 0 || b <= 0 || c <= 0){
            memo.put(a+"|"+b+"|"+c, 1);
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            memo.put(a+"|"+b+"|"+c, recursion(20, 20, 20));
            return memo.get(a+"|"+b+"|"+c);
        }
        if( a < b && b < c){
            memo.put(a+"|"+b+"|"+c, recursion(a, b, c-1) + recursion(a, b-1, c-1) - recursion(a, b-1, c));
            return memo.get(a+"|"+b+"|"+c);
        }

        memo.put(a+"|"+b+"|"+c, recursion(a-1, b, c) + recursion(a-1, b-1, c) + recursion(a-1, b, c-1) - recursion(a-1, b-1, c-1));
        return memo.get(a+"|"+b+"|"+c);
    }

 
}