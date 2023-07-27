package examplenote;

public class Example140107 {


    public static void main(String[] args) {
        int k = 2;
        int d = 4;
        System.out.println(solution2(k,d));
    }


    public static long solution2(int k, int d){
        long result = 0;

        double dPow = (double)Math.pow(d,2);

        for(int i =0; i <=d; i+=k ){

      /*      x2 + y2 = d;
            y2 = d - x2;
            y2 = d2 - x2;*/
            double _tmp = dPow - Math.pow(i,2);

            System.out.println(Math.sqrt(_tmp));

            result += (long)Math.sqrt(_tmp)/k+1;
        }

        return result;
    }


}
