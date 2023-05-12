import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//백준 - https://www.acmicpc.net/problem/10815 S5
public class Main {

    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Boolean> tree = new HashMap<>();

        int numberCount = Integer.parseInt(br.readLine());
        String numbers [] = br.readLine().split(" ");
        int i = 0;
        while(i < numberCount){
            tree.put(numbers[i], true);
            i++;
        }
        
        int sgNumberCount = Integer.parseInt(br.readLine());
        String sgNumbers [] = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        i = 0;
        while(i < sgNumberCount){
            boolean num = tree.get(sgNumbers[i]) != null && tree.get(sgNumbers[i]) ? true : false;
            if(num) sb.append("1 ");
            else sb.append("0 ");
            i++;
        }
        
        System.out.println(sb.toString());

    }
}
