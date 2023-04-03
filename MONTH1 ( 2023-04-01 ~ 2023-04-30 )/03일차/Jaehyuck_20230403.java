package base;
import java.util.*;
// 프로그래머스 -> 혼자 놀기의 달인 lv2
// https://school.programmers.co.kr/learn/courses/30/lessons/131130
public class Jaehyuck_20230403 {

	public static void main(String[] args) {
		int[] cards = {8,6,3,7,2,5,1,4};
		
	}
	

	class Solution {
	    public int solution(int[] cards) {
	        int answer = 0;
	        int nextNum = 1;
	        int [] group = new int [cards.length];
	        boolean [] usingCards = new boolean [cards.length];
	        
	        
	        
	        for(int i = 0; i<usingCards.length;i++){
	            if(!usingCards[i]){
	               // 박스 순환
	            	if(i >0)nextNum = i+1;
	              for(int j = 0; j < cards.length;j++){
	                 if(usingCards[nextNum-1]) {
	                	 if(answer == cards.length+1) answer = 0;
	                      group[i] = answer;
	                        break;
	                     }
	                 usingCards[nextNum-1] = true;
	                 nextNum = cards[nextNum-1];
	                    answer++;
	                  }
	                
	            } else {
	                continue;
	            }
	            if(answer == cards.length) answer = 0;
	            answer = 0;
	        }
	        Arrays.sort(group);
	        return group[cards.length-1]*group[cards.length-2];
	    }
	}

}
