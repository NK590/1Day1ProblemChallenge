package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/17681
 *
 * */
public class sangwoo {


    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(solution(n,arr1,arr2));
    }


    public static String[] solution(int n, int[] arr1, int[] arr2){
        String[] result = new String[arr1.length];

        String tmp1 = "";
        String tmp2 = "";
        for(int i = 0; i < arr1.length;i++){

            tmp1 = "";
            tmp2 = "";
            tmp1 = Integer.toBinaryString(arr1[i]);
            tmp2 = Integer.toBinaryString(arr2[i]);

            long tmpSum = Long.parseLong(tmp1) + Long.parseLong(tmp2);

            result[i] = String.format("%"+n+"s",String.valueOf(tmpSum).replaceAll("1","#").replaceAll("2","#").replaceAll("0"," "));

        }
        for(String x : result){
            System.out.println(x);
        }

        return result;
    }
}
