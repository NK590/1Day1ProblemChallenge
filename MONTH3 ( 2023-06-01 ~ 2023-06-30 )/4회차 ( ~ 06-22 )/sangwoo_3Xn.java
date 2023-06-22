package examplenote;

/**
 *
 * url :
 *
 * */
public class Example12902_ {


    public static void main(String[] args) {

        int n  = 5000;
        System.out.println(solution(n));
    }

    /**
     * The Number of cases
     *
     * 0 = 0
     * 1 = 0
     * 2 = 3
     * 3 = 0
     * 4 = 11
     * 5 = 0
     * 6 = 41
     *
     * 8 = 153
     *
     * */
    public static int solution(int n){

        if(n%2 !=0){
            return 0;
        }

        double[] arr = new double[n+1];
        arr[1] = 0;
        arr[2] = 3;
        arr[4] = 11;

        for(int i = 6; i <=n; i+=2 ){

            arr[i] = (((arr[i-2]*4)  %1000000007) - (arr[i-4] % 1000000007) +1000000007)%1000000007;

        }



        return (int)arr[n] % 1000000007;
    }

}
