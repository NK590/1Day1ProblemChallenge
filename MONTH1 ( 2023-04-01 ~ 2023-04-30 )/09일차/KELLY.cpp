/**
 * @file P_12909.cpp
 * @author KELLY
 * @brief Programmers 올바른 괄호(12909)
 * @version 0.1
 * @date 2023-04-09
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>

#include <string>
#include <vector>


using namespace std;

bool solution(string s)
{
	vector<char> left_gwalho_stack = {};

	for(char ch : s) {
		// ( 일때는 stack에 담고
		if(ch == '(') {
			left_gwalho_stack.push_back('(');
		}
		// ) 일때는 ( stack에서 하나 없애기
		// 이때 stack의 size 가 0이면 바로 false return
		else if(ch == ')') {
			if(left_gwalho_stack.size() == 0) return false;
			else {
				left_gwalho_stack.pop_back();
			}
		}
	}

	// ( stack의 size가 0이면 true, 아니면 false
	if(left_gwalho_stack.size() == 0) return true;
	else return false;
}

int main() {
	string s = "(())()";
	cout << solution(s) << endl;
}