/**
 * @file P_172928.cpp
 * @author KELLY
 * @brief Programmers 공원 산책 (172928)
 * @version 0.1
 * @date 2023-04-13
 * 
 * @copyright Copyright (c) 2023
 * 
 */
#include <iostream>

#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
	int x = park.size(); // 전체 행길이
	int y = park[0].length(); // 전체 열길이
	vector<int> current_spot = {0, 0};

	// 시작 위치 찾기
	for(int i = 0; i < park.size(); i++) {
		for(int j = 0; j < park[i].length(); j++) {
			char ch = park[i][j];

			if(ch == 'S') {
				current_spot[0] = i;
				current_spot[1] = j;
			}
		}
	}

	// 이동하기
	for(string route : routes) {
		vector<int> temp_current_spot = current_spot;
		string direction_str = route.substr(0,1);
		string cnt_str = route.substr(2,3);

		int cnt = stoi(cnt_str);
		int target_idx = 0 ;
		char gubun = '+';
		if("N" == direction_str) {
			target_idx = 0;
			gubun = '-';
		}
		if("S" == direction_str) {
			target_idx = 0;
			gubun = '+';
		}
		if("W" == direction_str) {
			target_idx = 1;
			gubun = '-';
		}
		if("E" == direction_str) {
			target_idx = 1;
			gubun = '+';
		}

		bool isPosbl = true;
		for(int i = 0; i < cnt; i++) {
			if(gubun == '+') {
				temp_current_spot[target_idx]++;
			}
			else {
				temp_current_spot[target_idx]--;
			}

			if(temp_current_spot[0] < 0 || temp_current_spot[0] >= x
				|| temp_current_spot[1] < 0 || temp_current_spot[1] >= y) 
			{
				isPosbl = false;
				break;
			}

			if(park[temp_current_spot[0]][temp_current_spot[1]] == 'X') {
				isPosbl = false;
				break;
			}
		}

		if(isPosbl) {
			current_spot = temp_current_spot;
		}
	}

    return current_spot;
}

int main() {
	vector<string> park = {"SOO","OOO","OOO"};
	vector<string> routes = {"E 2","S 2","W 1"};
	vector<int> results = solution(park, routes);
	for(int target : results) {
		cout << target << endl;
	}
}