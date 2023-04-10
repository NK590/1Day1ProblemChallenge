package April;

//프로그래머스 스킬트리 lv2 (summer/winter ~2018)
//https://school.programmers.co.kr/learn/courses/30/lessons/49993#fnref1
public class Jaehyuck_20230410 {

	public static void main(String[] args) {
		
		
        String[] skill_trees = {"ABX"};
        String skill  = "Z";
        int answer = 0;
        int [] idx = {};
        for(int i=0;i<skill_trees.length;i++){
        	 // skill 의 인덱스찾기
        	idx = new int[skill.length()];
            for(int j=0;j<skill.length();j++){
               idx[j] = skill_trees[i].indexOf(skill.charAt(j));
           }
          //인덱스 위치비교 (앞에 수가 있고 뒷수보다 앞에있고, 마지막인덱스가 없을경우 마지막까지 오면 성공)
            for(int k=0;k<idx.length-1;k++) {
            	if((idx[k+1] > idx[k] && idx[k] != -1) || idx[k+1] == -1){
            	    if(k == idx.length-2) {
            		    answer++;
            	    }   
                } else break;
            }
         // skill 이 1개라면 무조건 성공
            if(idx.length == 1) answer++;
            
     
        }
        
        
        System.out.println(answer);

	}

}
