#include <stdio.h>
#include <math.h>
#include <time.h>

long long solution(int r1, int r2);
long long getPointCount(int r, int io);
long long getDistance(int x, int y);
int getHeight(int x, int y, int io, long long r2);

int main(void){
    //두 원 사이의 정수 쌍

    //     문제 설명
    // x축과 y축으로 이루어진 2차원 직교 좌표계에 중심이 원점인 서로 다른 크기의 원이 두 개 주어집니다. 반지름을 나타내는 두 정수 r1, r2가 매개변수로 주어질 때, 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 return하도록 solution 함수를 완성해주세요.
    // ※ 각 원 위의 점도 포함하여 셉니다.

    //제한 사항
    //1 ≤ r1 < r2 ≤ 1,000,000
    
    clock_t start = clock();
 
    printf("result :: %lld\n", solution(200000, 300000));

    clock_t end = clock();
    printf("time: %lf\n", (double)(end - start) / CLOCKS_PER_SEC); 
    return 0;
}

long long solution(int r1, int r2) {
    return getPointCount(r2, 0) - getPointCount(r1, 1);
}

//테두리를 따라 계산하는 방법 (재귀)
long long getPointCount(int r, int io){
   long long result = 0;
   long long r2 = (long long)r * r;
    
   //반호를 따라서 안에 값 확인
   int y = r;
    for(int i = 0 ; i <= r ; i++ ){
        y = getHeight(i, y, io, r2);
        result += y+1;
        if(io && i == r) result -= 1; //작은원 마지막 값 빼주기            
    }    
    //곱하기 4 후 겹치는 부분 제거
    result = result << 2;
    if(io) result -= ((r-1) << 2) + 3;
    else result -= (r << 2) + 3;
    return result;
}



//각 좌표까지의 거리 계산
long long getDistance(int x, int y){
    long long width = x == 0 ? 0 : (long long) x * x;
    long long height = y == 0 ? 0 : (long long) y * y;
    return width + height;
}

//원안에서 x값에 대해서 가장 높은 y값 획득
int getHeight(int x, int y, int io, long long r2){
    if(y == 0) return 0;
    long long distance = 0;
    distance = getDistance(x, y);
    if(io){
        //printf("round distance :: %lld, x :: %lld, y:: %lld, distance :: %lld \n", r2, x, y, distance);
        if(r2 > distance) return y;
        else return getHeight(x, y-1, io, r2);
    }else {
        if(r2 >= distance) return y;
        else return getHeight(x, y-1, io, r2);
    }
}
