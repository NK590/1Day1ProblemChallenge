/*
    Programmers 콜라 문제 (132267)
*/

#include <iostream>

#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;

    while (n >= a) {
        int divided = n / a;
        int remained = n % a;

        answer += divided * b;
        n = (divided * b) + remained;
    }

    return answer;
}

int main() {
    int a = 2;
    int b = 1;
    int n = 20;
    cout << solution(a, b, n) << endl;
}