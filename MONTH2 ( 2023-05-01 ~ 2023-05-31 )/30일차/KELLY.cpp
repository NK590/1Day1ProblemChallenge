/*
    Programmers n^2 배열 자르기 (87390)
*/

#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    
    for (long long i = left; i <= right; i++) {
        // cout << i / n << " " << i % n << endl;
        
        long long x = i / n;
        long long y = i % n;
        long long num = 0;
        if (x > y) num = x + 1;
        else num = y + 1;
        
        answer.push_back(num);
    }

    return answer;
}

int main() {
    int n = 4;
    long long left = 7;
    long long right = 14;

    for (int answer : solution(n, left, right)) {
        cout << answer << endl;
    }
}