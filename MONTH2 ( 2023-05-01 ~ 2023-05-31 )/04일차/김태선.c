#include <stdio.h>
#include <string.h>
#include <time.h>


void setTime(struct tm* time1, struct tm* time2);
int solution(const char*** book_time, size_t book_time_rows, size_t book_time_cols) ;

//프로그래머스 호텔 대실

// 문제 설명
// 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
// 예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ book_time의 길이 ≤ 1,000
// book_time[i]는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
// [대실 시작 시각, 대실 종료 시각] 형태입니다.
// 시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
// 예약 시각이 자정을 넘어가는 경우는 없습니다.
// 시작 시각은 항상 종료 시각보다 빠릅니다.

int main(void){
    clock_t start = clock();
    const char* times [5][2] = {{"15:00", "17:00"},{"16:40", "18:20"},{"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}};
    size_t book_time_rows = 5;
    size_t book_time_cols = 2;

    const char*** book_time = (const char***)times;

    printf("result :: %d", solution(book_time, book_time_rows, book_time_cols));


    clock_t end = clock();
    printf("time: %lf\n", (double)(end - start) / CLOCKS_PER_SEC); 
    return 0;
}

int solution(const char*** book_time, size_t book_time_rows, size_t book_time_cols) {
    int answer = 0;

    struct tm times [book_time_rows][2];
    memset(times, 0, sizeof(times));

    //입퇴실 시간 파싱
    struct tm* tTime = NULL;
    for(int i = 0 ; i < book_time_rows ; i++){
        struct tm inTime = {0};
        strptime(book_time[i][0], "%H:%M", &inTime);
        setTime(&times[i][0], &inTime);
        struct tm outTime = {0};
        strptime(book_time[i][1], "%H:%M", &outTime);
        
        //청소시간
        tTime = &outTime;
        tTime -> tm_min = tTime -> tm_min + 10;
        if(tTime -> tm_min >= 60 ){
            tTime -> tm_hour += 1;
            tTime -> tm_min %= 60;
        }
        setTime(&times[i][1], tTime);
    }
    
    //각 입실자별로 중복된 객실 숫자중에 가장 큰 중복값을 확인
    for(int i = 0 ; i < book_time_rows ; i++){
        int dupl = 0;
        for(int y = 0 ; y < book_time_rows ; y++){
            if(i == y) continue;
            double in = difftime(mktime(&times[i][0]), mktime(&times[y][0]));
            double out = difftime(mktime(&times[i][0]), mktime(&times[y][1]));      
            if(in >= 0 && out < 0) dupl++;
        }
        if(answer < dupl) answer = dupl;
    }
    return ++answer;
}

//시간 구조체에 데이터 세팅
void setTime(struct tm* time1, struct tm* time2){
    time1 -> tm_year = time2 -> tm_year;
    time1 -> tm_mon  = time2 -> tm_mon;
    time1 -> tm_mday = time2 -> tm_mday;
    time1 -> tm_hour = time2 -> tm_hour;
    time1 -> tm_min = time2 -> tm_min;
    time1 -> tm_sec = time2 -> tm_sec;
}
