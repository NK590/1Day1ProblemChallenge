package examplenote;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/131127
 *
 *
 * */
public class Example131127 {

    public static void main(String[] args) {

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,number,discount));
    }

    public static int solution(String[] want, int[] number, String[] discount){

        int result = 0;
        String[] tmpDiscount = {};
        boolean flag = false;
        for(int i = 0; i < discount.length; i++){
            tmpDiscount = Arrays.copyOfRange(discount, i,i+10);
            flag = false;
            for(int j = 0; j < want.length; j++) {
                int cnt = Collections.frequency(Arrays.asList(tmpDiscount), want[j]);
                System.out.println(number[j] +" number j   :       cnt"+cnt );
                if(number[j] > cnt){
                    System.out.println("@@@@@@@@@@@@@@");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("!!!!!!!!!!!");
                result++;
            }
        }

        return result;

    }
}

