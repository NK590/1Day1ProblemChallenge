/*
    Programmers 부족한 금액 계산하기 (82612)
*/

#include <iostream>

using namespace std;

long long solution(int price, int money, int count)
{
    long long answer = -1;
    long long total = 0;
    for (int i = 0; i < count; i++) {
        total += (i + 1) * price;
    }

    answer = total - money;
    if (answer < 0) answer = 0;
    return answer;
}

int main() {
    cout << solution(3, 20, 4) << endl;
}