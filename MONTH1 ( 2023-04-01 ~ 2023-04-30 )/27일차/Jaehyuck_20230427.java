package April;
import java.util.*;
// 프로그래머스 lv2 영어 끝말잇기 
// https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class Jaehyuck_20230427 {

	public static void main(String[] args) {
		int n =3;
		String [] words = {"tank", "kick", "know", "wheel", "land", 
				"dream", "mother", "robot", "tank"};
		
		
		int[] answer = new int[2];
		// 플레이어 순서와 몇번째 인지 정함 
        Map<Integer,Integer> person = new HashMap<Integer,Integer>();
        // 게임중 중복 단어 찾기
        Set<String> gameWord = new HashSet<String>();
        int index = 1;
        // 플레이어 입장~ 
        for(int i=1;i<=n;i++){
            person.put(i,0);
        }
        
        for(int i=0;i<words.length;i++){
        	// 마지막 플레이어가 지나면 다시 처음플레이어로 
            if(index == n+1) index =1;
            // 한번 돌때마다 정답 외친횟수 증가 
            person.put(index,person.get(index)+1);
            
            if(gameWord.contains(words[i])){
                break;
            }
            if(i>0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
                break;
            }
             gameWord.add(words[i]);
             index++;
            
        }
        // 모두 정답일경우 
        if(words.length == gameWord.size()){
          Arrays.fill(answer,0);  
        } else {
            answer[0] = index;
            answer[1] = person.get(index);
        }
       System.out.println(answer);

	}

}
