/*
    Programmers 점프와 순간이동 (12980)
*/

#include <iostream>

using namespace std;
int solution(int n) {
    int ans = 0;

    while (n != 0) {
        int remained = n % 2;
        int divided = n / 2;

        if (n == 1) {
            n--;
            ans++;
        }
        else if (remained == 0) {
            n = divided;
        }
        else {
            n = n - remained;
            ans++;
        }
    }


    return ans;
}

int main() {
    int n = 5;
    cout << solution(n) << endl;
}