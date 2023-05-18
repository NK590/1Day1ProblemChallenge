/**
 * @file P_2839.cpp
 * @author KELLY
 * @brief Baekjoon 설탕 배달 (2839)
 * @version 0.1
 * @date 2023-05-18
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>

using namespace std;

// N킬로그램 설탕을 배달 해야함
// 3킬로그램 봉지와 5킬로그램 봉지가 있다
// 봉지를 최소한으로 가져갈 때의 수를 구하는 프로그램

int main() {
	int n, z, w, five, three, min = -1;
	cin >> n;

	z = n / 5;
	five = z;

	for (int i = 0; i <= z; i++) {
		w = n - five * 5;
		three = w / 3;
		if (!(w % 3)) {
			min = three + five;
			break;
		}
		five--;
	}

	cout << min << endl;
	return 0;
}