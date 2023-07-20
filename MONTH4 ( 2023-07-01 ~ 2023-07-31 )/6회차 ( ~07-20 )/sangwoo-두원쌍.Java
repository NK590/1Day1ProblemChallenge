public class Example181187 {

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 4;
        System.out.println(solution2(r1,r2));

    }

    public static long solution2(int r1, int r2){
        long answer = 0;


        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);

        // r^2 = x^2 * y^
        // y^2 = r^2 - x^2
        // x^2 = r^2 - y^2

        long y1sum=0;
        long y2sum=0;
        long side =0;

        for(long i=0;i<=r2;i++){


            long y2 = (long)Math.sqrt(r2x-(long)Math.pow(i,2));

            long y1 = (long)Math.sqrt(r1x-(long)Math.pow(i,2));


            if(Math.sqrt((r1x-Math.pow(i,2)))%1==0){
                side++;
            }

            answer+=(y2-y1)*4;
        }

        answer+=side*4-4;



        return answer;
    }

}