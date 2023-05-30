package examplenote;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/161989
 *
 * */
public class sangwoo {

    public static void main(String[] args) {


        int n = 4;
        int m = 1;
        int[] section = {1,2,3,4};
        System.out.println(solution(n,m,section));
    }

    public static int solution(int n, int m, int[] section){


        int peak = section[0]-1;
        int answer = 0;

        int idx = 0;
        while(peak < section[section.length-1]){
            for(int i = idx; i < section.length;i++){
                if(section[i] > peak){
                    peak = section[i] + m -1;
                    idx = i;
                    answer++;
                }
            }
            //peak += m;
            System.out.println("peak : "+peak);
        }

        return answer;
    }
}
