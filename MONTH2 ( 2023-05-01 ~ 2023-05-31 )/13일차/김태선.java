import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

//백준 - https://www.acmicpc.net/problem/10815 S5
public class Main {

    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        TreeSet<Long> tree = new TreeSet<>();

        int numberCount = Integer.parseInt(br.readLine());
        String numbers [] = br.readLine().split(" ");
        int i = 0;
        while(i < numberCount){
            tree.add(Long.parseLong(numbers[i]));
            i++;
        }
        
        int sgNumberCount = Integer.parseInt(br.readLine());
        String sgNumbers [] = br.readLine().split(" ");
        StringBuffer sb = new StringBuffer();
        i = 0;
        while(i < sgNumberCount){
            if(tree.contains(Long.parseLong(sgNumbers[i]))) sb.append("1 ");
            else sb.append("0 ");
            i++;
        }
        
        System.out.println(sb.toString());

    }
}