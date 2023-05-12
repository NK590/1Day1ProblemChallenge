package examplenote;

import java.util.Arrays;

/**
 *
 * url :https://school.programmers.co.kr/learn/courses/30/lessons/12982
 *
 * */
public class sangwoo {


    public static void main(String[] args) {

        int[] d= {1,3,2,5,4};
        int budget = 9;
        System.out.println(solution(d,budget));
    }

    public static int solution(int[] d, int budget){

        Arrays.sort(d);

        int tmpBudget =  budget;
        int result = 0;
        for(int i =0;i<d.length; i++){
            tmpBudget -= d[i];
            result++;
            if(tmpBudget < 0){
                break;
            }
        }
        return result;

    }
}
