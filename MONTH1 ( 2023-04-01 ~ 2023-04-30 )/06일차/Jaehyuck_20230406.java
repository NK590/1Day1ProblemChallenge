package base;

public class Jaehyuck_20230406 {

	public static void main(String[] args) {
		
		String number ="4177252841";
		int k = 4;
		String answer = "";
        StringBuffer sb = new StringBuffer();
        int cnt =0;
        int i=0;
        int j =1;
        sb.append(number);
        while (cnt < k ){
            // loop 를 다돌고 길이가 더 길다면 마지막 문자제거
            if(i == sb.length()-1){
                 sb.deleteCharAt(i);
                break;
            }
            // 앞뒤를 비교해서 앞이 작으면 삭제
            if(sb.charAt(i) < sb.charAt(j)){
               sb.deleteCharAt(i);
               if(i >0){
                j--;
                i--;
               }
                 cnt++;
           }  else {
                i ++;
                j ++;
            }
        }
    
       answer = sb.toString();
        System.out.println(answer);
	}

}
