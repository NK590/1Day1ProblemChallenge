/*
    Programmers Á¡Âï±â(140107)
*/

#include <iostream>
#include <string>
#include <cmath>

using namespace std;


long long solution(int k, int d) {
    long long answer = 0;

    int i_idx = 0;
    int j_idx = 0;

    if(k == 0 || d == 0) return answer;
    //for (int i = 0; i <= sqrt(pow(d, 2)); i = ++i_idx * k) {
    //    j_idx = 0;
    //    for (int j = 0; j <= sqrt(pow(d, 2) - pow(i, 2)); j = ++j_idx * k) {
    //        // cout << i << " " << j << endl;
    //        answer++;
    //    }
    //}

    for (int i = 0; i <= sqrt(pow(d, 2)); i = ++i_idx * k) {
        // answer += (int)(sqrt(pow(d, 2) / pow(i, 2)));
        answer += (int)(sqrt(pow(d, 2) - pow(i, 2)) / k) + 1;
    }

    return answer;
}

int main() {
    int k, d = 0;
    cin >> k;
    cin >> d;

    cout << solution(k, d);
    return 0;
}