package examplenote;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/12901
 *
 * */
public class sangwoo {

    public static void main(String[] args) {

        int a = 5;
        int b = 24;

        System.out.println(solution(a,b));
    }

    public static String solution(int a, int b){

        LocalDate date = LocalDate.of(2016, a, b);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String result = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US);

        return result.toUpperCase();

    }
}
