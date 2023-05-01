package May;
import java.util.*;
// 프로그래머스 lv2 N개의 최소공배수
// https://school.programmers.co.kr/learn/courses/30/lessons/12953
public class Jaehyuck_20230501 {
	
	public static void main(String[] args) {
		int answer = 0;
        int [] arr = {2,6,8,14};
        // 최대공약수를 구하기 위한 정렬 
        Arrays.sort(arr);
        int c  = gcd(arr[0],arr[1]);
        answer = arr[0]*arr[1]/c;
        for(int i =2;i<arr.length;i++){
           c = gcd(answer,arr[i]);
           answer = answer*arr[i]/c;
        }
      System.out.println(answer);

	}
	
	public static int gcd(int a, int b) {
		 
		while (b != 0) {
			int r = a % b; 
			a = b;
			b = r;
		}
		return a;
	  }

}
