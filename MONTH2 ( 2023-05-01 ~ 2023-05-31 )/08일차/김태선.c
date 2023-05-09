// N-Queen G4
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 10 초	128 MB	91055	43737	28391	46.696%
// 문제
// N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
// N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
// 입력
// 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
// 출력
// 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
#include <stdio.h>
#include <stdlib.h>

int solution(int n);
int doCount(int queens[][2], int size, int level);
int chkPosible(int queens[][2], int x, int y);
void pop(int** stack);
void push(int** stack, int* item);


int top = 0;

int main(void){
    int testN = 0;
    scanf("%d", &testN);
    printf("%d", solution(testN));
    return 0;
}

int solution(int n){
    int result = 0;
    if(n == 1) return 1;
    //첫줄에 1 -> n 까지 퀸을 놓는다.
    int queens [n][2];
    for(int i = 0 ; i < n ; i++){
        queens[0][0] = i;
        queens[0][1] = 0;
        top = 1;
        int tempResult = doCount(queens, n, 1);
        result += tempResult;
    }
    return result;
}

int doCount(int queens[][2], int size, int level){
    int result = 0;
    if(size-1 == level){
        //마지막 레벨에서는 마지막줄에서 놓을 수 있는 자리의 개수를 리턴한다.
        for(int i = 0 ; i < size ; i++)
            if(chkPosible(queens, i, level)) result++;
        return result;
    }
    
    //0 -> n까지 내가 놓을 수 있는 자리에 퀸을 놓고 다음 레벨로 넘어간다.
    for(int i = 0 ; i < size ; i++){
        if(chkPosible(queens, i, level)){
            queens[top][0] = i;
            queens[top][1] = level;
            top++;
            result += doCount(queens, size, level+1);
            top--;
        }
    }
    
    return result;
}

//x, y에 대해서 퀸을 놓을 수 있는지 여부를 확인
int chkPosible(int queens [][2], int x, int y){
    for(int i = 0 ; i < y ; i++){
        //기존 퀸에 대해서 하나라도 조건에 안맞으면 false;
        int queenX = queens[i][0];
        int queenY = queens[i][1]; 
        if(queenX == x) return 0;   //수평일치
        if(queenY == y) return 0;   //수직일치
        if(abs(queenX - x) == abs(queenY - y)) return 0;    //대각일치
    }
    return 1;
}

void push(int** stack, int* item){
    stack[top] = item;
    top++;
}

void pop(int** stack){
    stack[top][0] = 0;
    stack[top][1] = 0;
    top--;
}
