package June;

public class Jaehyuck_programers_가장긴팰린드롬 {

	public static void main(String[] args) {
			int answer = 0;
			String s = "abcdcba";
	        // 가장길게부터 검색 
	        for(int i=s.length();i>1;i--){
	            // 1칸씩 줄이기 
	            for(int j=0;j+i<=s.length();j++){
	                boolean flag = true;
	                for(int k=0;k<i/2;k++){
	                    if(s.charAt(k+j) != s.charAt(i+j-k-1)){
	                        flag = false;
	                        break;
	                    }
	                }
	                if(flag) System.out.println(i);
	            }
	        }
	        
	        
	         System.out.println(1);

	}

}
