/*
    Programmers 숫자의 표현(12924)
*/

#include <iostream>

#include <string>
#include <vector>

using namespace std;

int proc(int sum, int next_num, int goal);
int solution(int n) {
    int answer = 0;

    for (int i = 1; i <= n; i++) {
        if (n == proc(0, i, n)) answer++;
    }

    return answer;
}

int proc(int sum, int next_num, int goal) {
    int cal = sum + next_num;
    if (goal == cal) {
        return goal;
    }
    else if (goal < cal) {
        return -1;
    }
    else {
        return proc(cal, next_num + 1, goal);
    }
}

int main() {
    int n = 15;
    cout << solution(n) << endl;
}