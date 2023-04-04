package base;
import java.util.*;
// 프로그래머스 -> 피로도 lv2
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Jaehyuck_20230404 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		Boolean[] chkPoint = new Boolean[dungeons.length];
		Arrays.fill(chkPoint,false);
		 int answer =0;
		  for(int i =0;i<dungeons.length;i++){
	           answer = Math.max(fn(k,dungeons,0,chkPoint),answer);    
	        }
		 System.out.println(answer);
	}
	

	 public static int fn(int k , int[][] dungeons,int n,Boolean [] chkPoint){
		 int max =0;
	        for(int i =0;i<dungeons.length;i++){
	            //방문하지 않은 던전이면 확인
	            if(!chkPoint[i]){
	                //던전입장가능
	              if(k>=dungeons[i][0]){
	                 k = k - dungeons[i][1];
	                 chkPoint[i] = true;
	                 max = Math.max(fn(k,dungeons,n+1,chkPoint),max);
	                 chkPoint[i] = false;
	                 k = k + dungeons[i][1];
	                 } 
	             }
	        
	         }
	        if(max >= n) return max;
	        else  return n;
	        
	    }

}
