package examplenote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * */
public class sangwoo {

    public static void main(String[] args) {

        int[] people = {70,80,50,50};
        int limit = 100;

        System.out.println(solution2(people,limit));
    }

    public static int solution(int[] people, int limit){

        int result = 0;
        //List<Integer> arr = Arrays.stream(people).boxed().collect(Collectors.toList());
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            arr.add(people[i]);
        }
        arr.sort(Collections.reverseOrder());
        int tmp = 0;
        boolean flag = true;
        for(int i = 0; i < arr.size(); i++){
            flag = true;
            tmp = arr.get(i);
            if(tmp < limit) {
                for (int j = i + 1; j < arr.size(); j++) {
                    if (tmp + arr.get(j) <= limit) {
                        result++;
                        arr.remove(j);
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                result++;
            }
        }

        return result;
    }

    public static int solution2(int[] people, int limit){

        int result = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        while(left <= right){
            if(people[left] + people[right] <=limit){
                left++;
            }
            right--;
            result++;
        }
        return result;
    }
}
