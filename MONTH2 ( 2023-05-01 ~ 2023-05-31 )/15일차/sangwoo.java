package examplenote;


/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/12917
 *
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class sangwoo {


    public static void main(String[] args) {

        String s = "Zbcdefg";

        System.out.println(solution2(s));
    }

    public static String solution(String s){


        char[] tmpCharArray = s.toCharArray();
        for(int i=1; i < tmpCharArray.length; i++){
            for(int j=i ; j >= 1; j--){
                if(compareTo(tmpCharArray[j],tmpCharArray[j-1] ) < 1 ){
                    char tmp = tmpCharArray[j];
                    tmpCharArray[j] = tmpCharArray[j-1];
                    tmpCharArray[j-1] = tmp;
                }else break;

            }
        }
        return new String(tmpCharArray);
    }

    public static int compareTo(char s1, char s2){
        if(Character.toLowerCase(s1) >= Character.toLowerCase(s2)){
            if(Character.isUpperCase(s1)){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }

    public static String solution2(String s){

        List<Character> upperList = new ArrayList<>();
        List<Character> lowerList = new ArrayList<>();
        String[] sArr =  s.split("");
        for(int i = 0; i < s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))){
                upperList.add(s.charAt(i));
            }else{
                lowerList.add(s.charAt(i));
            }
        }

        Collections.sort(upperList,Collections.reverseOrder());
        Collections.sort(lowerList, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for(char x : lowerList){
            result.append(x);
        }

        for(char x : upperList){
            result.append(x);
        }
        return result.toString();
    }
}
