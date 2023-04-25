/*
	Programmers 둘만의 암호 (155652)
*/

#include <iostream>

#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(string s, string skip, int index) {
	string answer = "";

	map<char, int> alphabet;
	map<int, char> alphabet_idx;
	int j = 0;
	int a = (int)'a';
	int z = (int)'z';
	for (int i = a; i <= z; i++) {
		if (skip.find((char)i) == string::npos) {
			alphabet.insert({ i, j });
			alphabet_idx.insert({ j, i });
			j++;
		}
	}

	for (char ch : s) {
		int idx = alphabet[ch];
		int next_idx = idx + index;

		if (next_idx >= alphabet_idx.size()) {
			next_idx %= alphabet_idx.size();
		}

		answer += alphabet_idx[next_idx];


	}

	return answer;
}

int main() {
	cout << solution("zzzz", "abcde", 5) << endl;
}