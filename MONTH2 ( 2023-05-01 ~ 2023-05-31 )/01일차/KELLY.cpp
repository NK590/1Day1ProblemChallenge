/**
 * @file P_12981.cpp
 * @author KELLY
 * @brief Programmers 영어 끝말잇기 (12981)
 * @version 0.1
 * @date 2023-05-01
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

vector<int> solution(int n, vector<string> words)
{
	vector<int> answer;

	string before_str = "";
	map<string, int> words_map;
	for (int i = 0; i < words.size(); i++)
	{
		string current_str = words[i];

		// before and current char check
		if (before_str != "")
		{
			char before_char = before_str[before_str.size() - 1];
			char current_char = current_str[0];

			if (before_char != current_char)
			{
				answer.push_back((i % n) + 1);
				answer.push_back((i / n) + 1);
				break;
			}
		}

		// duplicated word check
		if(words_map.find(current_str) == words_map.end()) {
			words_map.insert({current_str, 0});
		}
		else {
			answer.push_back((i % n) + 1);
			answer.push_back((i / n) + 1);
			break;
		}

		before_str = current_str;
	}

	if(answer.size() == 0) {
		answer.push_back(0);
		answer.push_back(0);
	}
	return answer;
}

int main()
{
	int n = 2;
	vector<string> words = {"hello", "one", "even", "never", "now", "world", "draw"};
	for (int result : solution(n, words))
	{
		cout << result << endl;
	}
}