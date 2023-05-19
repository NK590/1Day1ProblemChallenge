package examplenote;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/42578
 *
 * */
public class sangwoo {

    public static void main(String[] args) {

    }

    public static int solution(String[][] clothes){

        int result = 1;

        Map<String,Integer> keyCntMap = new HashMap<String,Integer>();
        for(String[] strArr : clothes){
            if(keyCntMap.containsKey(strArr[1])){
                keyCntMap.put(strArr[1],keyCntMap.get(strArr[1])+1);
            }else{
                keyCntMap.put(strArr[1],1);
            }
        }

        for (String key : keyCntMap.keySet()) {
            result = result * (keyCntMap.get(key) +1);
        }

        return result -1;

    }

}
