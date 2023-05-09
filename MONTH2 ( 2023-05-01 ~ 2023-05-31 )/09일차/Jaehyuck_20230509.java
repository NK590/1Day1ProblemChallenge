package May;
import java.util.*;
// 프로그래머스 lv1 나머지가 1이 되는 수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/87389

public class Jaehyuck_20230509 {

	public static void main(String[] args) {
		int n =10;
		int answer = 0;
        n = n-1;
        for(int i=2;i<=Math.sqrt(n);i++){
            System.out.println(n%i);
            if(n % i == 0){
                answer = i;
                break;
            }
           answer = n;
        }
        System.out.println(answer);

	}

}
