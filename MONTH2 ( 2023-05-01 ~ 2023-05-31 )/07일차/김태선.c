#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int* solution(const char* maps[], size_t maps_len);
int searchInt(int x, int y, int width, int height, char* maps[]);
int compare (const void* first, const void* second);

int main(void){
    const char* maps[4] = {"X591X", "X1X5X", "X231X", "1XXX1"};

    solution(maps, 4);

    return 0;
}

int* solution(const char* maps[], size_t maps_len) {
    const int height = maps_len;
    const int width  = strlen(maps[0]);

    //변수 옮겨 담기
    char* map [maps_len];
    for(int i = 0 ; i < height ; i++){
        map[i] = (char*)malloc(sizeof(char) * width);
        strcpy(map[i], maps[i]);
    }
    //탐색 시작
    int tStack [height*width];
    memset(&tStack, 0, sizeof(tStack));
    int top = 0;
    for(int i = 0 ; i < height ; i++){
        for(int j = 0 ; j < width ; j++){
            if(map[i][j] != 'X'){
                tStack[top] = searchInt(j, i, width, height, map);
                top++;
            }
        }
    }
    //하나도 섬이 없으면 -1 리턴
    if(tStack[0] == 0){
        int* result = (int*)malloc(sizeof(int) * 1);
        result[0] = -1;
        return result;
    }
    //정렬 후 반환
    int* answer = (int*)malloc(sizeof(int) * top); //답안 리스트
    for(int i = 0 ; i < top ; i++)
        answer[i] = tStack[i];
    qsort(answer, top, sizeof(int), compare);
    return answer;
}

//사방 탐색 후 바다가 아니거나 이미 탐색한 곳이 아니면 해당 숫자값 획득
int searchInt(int x, int y, int width, int height, char* maps[]){
    if(maps[y][x] == 'X') return 0;
    char tSupl = maps[y][x];
    int result = atoi(&tSupl);
    maps[y][x] = 'X';
    if(x > 0) result += searchInt(x-1, y, width, height, maps);
    if(x < width-1) result += searchInt(x+1, y, width, height, maps);
    if(y > 0) result += searchInt(x, y-1, width, height, maps);
    if(y < height-1) result += searchInt(x, y+1, width, height, maps);
    return result;
}

//정렬기능
int compare (const void* first, const void* second){
    if (*(int*)first > *(int*)second) return 1;
    else if (*(int*)first < *(int*)second) return -1;
    else return 0;
}
