/**
 * @file P_160586.cpp
 * @author KELLY
 * @brief Programmers 대충 만든 자판 (160586)
 * @version 0.1
 * @date 2023-04-16
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>

#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
	map<char, int> keymap_idx_map;

	for(string str : keymap) {
		for(int i = 0; i < str.length(); i++) {
			char ch = str[i];

			if(keymap_idx_map.find(ch) != keymap_idx_map.end()) {
				int idx = keymap_idx_map[ch];

				if(i < idx) keymap_idx_map[ch] = i;
			}
			else {
				keymap_idx_map.insert({ch, i});
			}
		}
	}

	for(string target : targets) {
		int sum = 0;
		bool isPosbl = true;
		for(int i = 0; i < target.size(); i++) {
			char ch = target[i];

			if(keymap_idx_map.find(ch) != keymap_idx_map.end()) {
				sum += keymap_idx_map[ch] + 1;
			}
			else {
				isPosbl = false;
				break;
			}
		}

		if(isPosbl) {
			answer.push_back(sum);
		}
		else {
			answer.push_back(-1);
		}
	}

    return answer;
}

int main() {
	vector<string> keymap = {"FFF", "DDD"};
	vector<string> targets = {"ABCD","AABB"};
	for(int result : solution(keymap, targets)) {
		cout << result << endl;
	}
}