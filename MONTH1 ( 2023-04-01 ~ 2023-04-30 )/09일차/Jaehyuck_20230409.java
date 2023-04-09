package April;

// 프로그래머스 카드뭉치 Lv1 
// https://school.programmers.co.kr/learn/courses/30/lessons/159994

public class Jaehyuck_20230409 {
	public static void main(String[] args) {
	
        String [] cards1 = {"i", "water", "drink"};
        String [] cards2 = {"want", "to"};
        String [] goal = {"i", "want", "to", "drink", "water"};
        
        String answer = "No";
        int n = 0;
        int m = 0;
        boolean box1 = true;
        boolean box2 = true;
        //카드뭉치가 더 크면 만들수없음  
        if(cards1.length+cards2.length<goal.length)// return answer;
        answer = "Yes";
        for(int i=0;i<goal.length;i++){
        //다쓴 카드더미는 더이상 못쓰게함
            if(n == cards1.length) box1 = false;
            else if(m == cards2.length) box2 = false;
            
            if(box1 && goal[i].equals(cards1[n])) n++;
            else if(box2 && goal[i].equals(cards2[m])) m++;
            else{
                answer="No";
                break;
            }
                        
        }
    
        
        System.out.println(answer);
    

	}

}
