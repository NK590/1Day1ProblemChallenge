/**
 * @file P_178871.cpp
 * @author KELLY
 * @brief Programmers 달리기 경주 (178871)
 * @version 0.1
 * @date 2023-04-15
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>

#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer = players;
	map<string, int> players_idx_map;
	map<int, string> players_idx_map_2;

	for(int i = 0; i < players.size(); i++) {
		players_idx_map.insert({players[i], i});
		players_idx_map_2.insert({i, players[i]});
	}

	for(string calling : callings) {
		int current_idx = players_idx_map[calling];

		string temp = answer[current_idx - 1];
		answer[current_idx - 1] = answer[current_idx];
		answer[current_idx] = temp;
		
		players_idx_map[calling] = current_idx -1;
		players_idx_map[temp] = current_idx;
		// players_idx_map.insert({calling, current_idx - 1});
		// players_idx_map.insert({temp, current_idx});

		// players_idx_map2.insert({current_idx - 1, calling});
		// players_idx_map2.insert({current_idx - 1, calling});
	}

    return answer;
}

int main() {
	vector<string> players = {"mumu", "soe", "poe", "kai", "mine"};
	vector<string> callings = {"kai", "kai", "mine", "mine"};
	for(string result : solution(players, callings)) {
		cout << result << endl;
	}
}