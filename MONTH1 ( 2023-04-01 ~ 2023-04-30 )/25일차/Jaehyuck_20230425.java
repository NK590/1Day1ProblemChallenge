package April;
import java.util.*;
//프로그래머스 lv2 최솟값 만들기 
//https://school.programmers.co.kr/learn/courses/30/lessons/12941

public class Jaehyuck_20230425 {
	//정렬후 가장 큰수 *  가장작은수 
	public static void main(String[] args) {
		int answer = 0;
		int [] A = {1,4,2};
		int [] B = {5,4,4};
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            answer += A[i] * B[B.length-1-i];
        }

	}

}
