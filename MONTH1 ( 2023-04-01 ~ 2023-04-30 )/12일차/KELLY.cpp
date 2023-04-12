/**
 * @file P_12945.cpp
 * @author KELLY
 * @brief Programmers 피보나치 수(12945)
 * @version 0.1
 * @date 2023-04-12
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>

#include <string>
#include <vector>

using namespace std;

long long proc(long long now, long long pre, int cnt, int end);
int solution(int n) {
    int answer = 0;

	answer = proc(0, 0, 0, n);
    return answer;
}

long long proc(long long now, long long pre, int cnt, int end) {
	if(cnt == 0 ) {
		return proc(0, 0, 1, end);
	}
	else if(cnt == 1) {
		return proc(1, 1, 2, end);
	}
	else if(cnt == end) {
		return now;
	}
	else {
		return proc(((now % 1234567) + (pre % 1234567)) % 1234567, (now % 1234567), cnt + 1, end);
	}
}

int main() {
	int n = 5;
	cout << solution(n) << endl;
}
