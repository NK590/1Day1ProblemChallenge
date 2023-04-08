package April;

import java.util.HashMap;
import java.util.Map;
//프로그래머스 달리기 경주 lv1
//https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class Jaehyuck_20230408 {

	public static void main(String[] args) {
		
		String [] players = {"mumu", "soe", "poe", "kai", "mine"};
		String [] callings = {"kai", "kai", "mine", "mine"};
		String[] answer = {};
        String temp;
        int n =0;
        //map에 선수와 순위담기
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        //맵을 이용해서 선수 가져오기 (배열 index 로 돌리면 시간초남)
        for(int i=0;i<callings.length;i++){
            n = map.get(callings[i]);
            map.put(players[n],n-1);
            map.put(players[n-1],n);
            temp = players[n-1];
            players[n-1] = players[n];
            players[n] = temp;
 
            
        }
        answer = players.clone();
        System.out.println(answer);
	}

}
