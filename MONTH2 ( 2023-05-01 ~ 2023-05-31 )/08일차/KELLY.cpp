/**
 * @file P_12947.cpp
 * @author KELLY
 * @brief Programmers 하샤드 수 (12947)
 * @version 0.1
 * @date 2023-05-08
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>

#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;

	string x_str = to_string(x);
	int x_char_int_sum = 0;
	for(char x_char : x_str) {
		int x_char_int = x_char - '0';

		x_char_int_sum += x_char_int;
	}
	
	if(x % x_char_int_sum == 0) answer = true;
	else answer = false;

    return answer;
}

int main() {
	int x = 10;
	cout << solution(x) << endl;
}