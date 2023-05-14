
/**
 * @file P_1065.cpp
 * @author KELLY
 * @brief Baekjoon 한수 (1065)
 * @version 0.1
 * @date 2023-05-14
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>

using namespace std;


int main() {
	int count = 0;
	int n = 0;

	cin >> n;

	for (int i = 1; i <= n; i++) {
		if (i >= 1 && i < 100) count = i;
		else if (i == 1000) break;
		else {
			int a = i % 1000 / 100;
			int b = i % 100 / 10;
			int c = i % 10;

			if (a - b == b - c) count++;
		}
	}
	cout << count << endl;
}
