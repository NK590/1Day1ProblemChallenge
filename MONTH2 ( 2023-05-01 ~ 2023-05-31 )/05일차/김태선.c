#include <stdio.h>
#include <string.h>

void push(int* stack, int X);
int pop(int* stack);
int size();
int empty();
int top(int* stack);


// 스택 - S4
// 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

// 명령은 총 다섯 가지이다.

// push X: 정수 X를 스택에 넣는 연산이다.
// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
// size: 스택에 들어있는 정수의 개수를 출력한다.
// empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
// top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.


int pTop = 0; //스택 포인터


int main(void){

    int commanLineCount;
    scanf("%d\n", &commanLineCount);

    int stack [commanLineCount];
    int* st = &stack[0];
    //명령어 처리
    for(int i = 0 ; i < commanLineCount ; i++){
        char command[10];
        memset(&command, 0, sizeof(command));
        scanf("%s", &command[0]);

        if(strstr(&command[0], "push") != NULL){
            int number;
            scanf("%d", &number);
            push(st, number);
        }else if(strstr(&command[0], "pop") != NULL){
            printf("%d\n", pop(st));
        }else if(strstr(&command[0], "size") != NULL){
            printf("%d\n", size());
        }else if(strstr(&command[0], "empty") != NULL){
            printf("%d\n", empty());
        }else if(strstr(&command[0], "top") != NULL){
            printf("%d\n", top(st));
        }
        
    }
    return 0;
}

void push(int* stack, int X){
    stack[pTop] = X;
    pTop++;
}

int pop(int* stack){
    if(pTop == 0) return -1;
    return stack[--pTop];
}

int size(){
    return pTop;
}

int empty(){
    if(pTop == 0) return 1;
    else return 0;
}

int top(int* stack){
    if(pTop == 0) return -1;
    return stack[pTop-1];
}