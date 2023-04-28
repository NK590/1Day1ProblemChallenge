/*
    Programmers x��ŭ ������ �ִ� n���� ���� (12954)

*/

#include <iostream>

#include <string>
#include <vector>

using namespace std;

vector<long long> solution(int x, int n) {
    vector<long long> answer;
    
    for (int i = 1; i <= n; i++) {
        answer.push_back(x * i);
    }

    return answer;
}

int main() {
    int x = 2;
    int n = 5;

    for (long long result : solution(x, n)) {
        cout << result << endl;
    }
}