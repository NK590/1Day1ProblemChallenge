package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/17687
 *
 * */
public class sangwoo {

    public static void main(String[] args) {


        int n = 2;
        int t = 4;
        int m  = 2;
        int P = 1;

        System.out.println(solution(n,t,m,P));

        //011011100
    }

    public static String solution(int n, int t, int m, int P){

        String result = "";

        StringBuilder strBuilder = new StringBuilder();

        int cnt = m * (t-1) + P;
        int tmpCnt = 1;

        int number = 0;
        System.out.println(strBuilder.length());
        System.out.println("cnt : "+cnt);
        while(strBuilder.length() < cnt){

            System.out.println(Integer.toString(number,2));
            strBuilder.append(Integer.toString(number,n ).toUpperCase());
            number++;
        }

        System.out.println(strBuilder.toString());
        for(int i = (P-1) ; i < strBuilder.length(); i+=m){
            result += strBuilder.charAt(i)+"";
        }

        return result.substring(0,t);
    }
}
