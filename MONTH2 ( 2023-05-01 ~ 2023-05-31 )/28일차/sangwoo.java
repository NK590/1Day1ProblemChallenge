package examplenote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/42888
 *
 * */
public class sangwoo {

    public static void main(String[] args) {

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }

    public static String[] solution(String[] record){

        Map<String,String> nameList = new HashMap<String,String>();
        List<String[]> resultList = new ArrayList<>();
        int resultCnt = 0;
        for(int i = 0; i < record.length; i++){

            String[] tmp = record[i].split(" ");
            String status = tmp[0];

            if("Change".equals(status)){
                nameList.put(tmp[1],tmp[2]);
            }else{
                resultCnt++;
                if("Enter".equals(status)) {
                    nameList.put(tmp[1], tmp[2]);
                }
                String[] temp = new String[2];
                temp[0] = tmp[1];
                temp[1] = replaceStr(tmp[0]);
                resultList.add(temp);
            }
        }

        String[] result = new String[resultCnt];
        for(int i = 0; i < resultList.size(); i++){
            String[] listArr = resultList.get(i);
            result[i] = nameList.get(listArr[0])+"님이 "+(listArr[1]);
        }

        System.out.println(" ");
        for(String x : result){
            System.out.println(x);
        }
        return result;
    }

    public static String replaceStr(String eng){
        if("Enter".equals(eng)){
            return "들어왔습니다.";
        }else{
            return "나갔습니다.";
        }
    }
}
