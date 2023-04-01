package April;
import java.util.*;

//프로그래머스 -> 추억점수 Lv1
public class Jaehyuck_20230401 {

	public static void main(String[] args) {
			String [] name = {"may", "kein", "kain", "radi"};
			int [] yearning = {5, 10, 1, 3};
			String [][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
			
	}
	
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int result =0;
        for(int i=0;i<photo.length;i++){
            //정답초기화
            result =0;
            for(int j=0;j<name.length;j++){
                result += Collections.frequency(Arrays.asList(photo[i]),name[j]) * yearning[j];
            }
            answer[i] = result;
        }
        
        
        
        return answer;
    }

}
