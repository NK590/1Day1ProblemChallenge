/*
	Baekjoon ¸·´ë±â (1094)
*/

#include <iostream>
#include <bitset>

using namespace std;

int main() {
	int num = 0;
	cin >> num;

	string num_two = bitset<7>(num).to_string();

	int answer = 0;
	for (char ch : num_two) {
		if (ch == '1') {
			answer++;
		}
	}

	cout << answer << endl;
}