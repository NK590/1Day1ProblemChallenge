package examplenote;

/**
 *
 * url: https://school.programmers.co.kr/learn/courses/30/lessons/12918
 *
 * */
public class sangwoo {


    public static void main(String[] args) {
        String s = "";

        System.out.println(solution(s));
    }

    public static boolean solution(String s){
        if(s.length() == 4 || s.length() == 6){
            try{
                Integer.parseInt(s);
            }catch(NumberFormatException e){
                return false;
            }
        }else{
            return false;
        }
        return true;

    }
}
