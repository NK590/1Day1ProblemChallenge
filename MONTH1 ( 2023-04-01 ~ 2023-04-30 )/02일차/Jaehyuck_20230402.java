package April;

//프로그래머스 -> 틱택톡  Lv2
// https://school.programmers.co.kr/learn/courses/30/lessons/160585 

public class Jaehyuck_20230402 {

	public static void main(String[] args) {
		String [] board = {"O.X", ".O.", "..X"};
	}
	
	  public int solution(String[] board) {
	        int answer = 1;
	        int fst = 0;
	        int lst = 0;
	        int xBing = 0;
	        int oBing = 0;
	        String game = "";
	        String findBing ="";
	        for(int i=0;i<board.length;i++){
	              for(int j=0;j<board[i].length();j++){
	                if('O' == board[i].charAt(j)) fst++;
	                 else if('X' == board[i].charAt(j)) lst++;
	                  game += board[i].charAt(j);
	            }
	        }
	        // x 가 o 보다 많거나 o 가 x보다 2개이상많을때 룰 위반
	        if(lst > fst || fst > lst+1) return 0;
	        
	        // 빙고완성확인여부
	        int [][] bingNum = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
	        for(int i = 0; i<bingNum.length;i++){
	           findBing = "";
	           findBing += game.charAt(bingNum[i][0]);
	           findBing += game.charAt(bingNum[i][1]);
	           findBing += game.charAt(bingNum[i][2]);
	            if("OOO".equals(findBing)) oBing++;
	            else if("XXX".equals(findBing)) xBing++;
	        }
	        // x빙고가 2개이상이거나 o,x 둘다 빙고일경우 룰 위반
	        if(oBing >2 ||xBing>1 || (oBing == 1 && xBing == 1)) {
	            return 0;
	        }
	        // o가 빙고일경우 무조건 x보다 1개가 많아야함 (o빙고는 마지막에 2개를 만들수있음 )
	        else if((oBing == 1 && xBing ==0) || oBing == 2){
	            if(fst == lst + 1) return 1;
	            else return 0;
	        }
	        // x가 빙고일경우 갯수는 같아야함
	        else if(oBing == 0 && xBing ==1){
	            if(fst == lst ) return 1;
	            else return 0;
	        } 
	        //빙고가 없을경우 o가 1개 많거나 o랑x의 수가 같아햠
	        else{
	            if(fst == lst || fst == lst + 1) return 1;
	            else return 0;
	        }
	        
	    }

}
