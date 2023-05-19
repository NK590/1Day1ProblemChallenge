package examplenote;

import java.util.*;
/**
 *
 * url :https://school.programmers.co.kr/learn/courses/30/lessons/138476
 *
 * */
public class sangwoo {

    public static void main(String[] args) {

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution(k,tangerine));
    }

    public static int solution(int k, int[] tangerine){

        int result = 0;

        Map<Integer,Integer> cntMap = new HashMap<Integer,Integer>();

        for(int n : tangerine){

            if(cntMap.containsKey(n)){
                cntMap.put(n, cntMap.get(n)+1);
            }else{
                cntMap.put(n,1);
            }
        }


        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(cntMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int tmpSum = 0;
        for(Map.Entry<Integer,Integer> entry : entryList){
            tmpSum += entry.getValue();
            result++;
            if(tmpSum >=k){
                break;
            }
        }
        return  result;
    }
}
