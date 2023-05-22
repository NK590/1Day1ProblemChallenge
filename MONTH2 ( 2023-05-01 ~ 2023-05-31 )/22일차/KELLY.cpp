/*
	Baekjoon 접두사 (1141)
*/

#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(const pair<string, int>& a, const pair<string, int>& b);
int main() {
	int t = 0; cin >> t;

	map<string, int> str_map;
	map<string, int> group_map;

	while (t--) {
		string str = ""; cin >> str;

		// 중복 제거
		str_map.insert({str, 0});
	}

	// 글자 수로 오름차순으로 정렬
	int answer = 0;
	vector<pair<string, int>> str_vec(str_map.begin(), str_map.end());
	sort(str_vec.begin(), str_vec.end(), cmp);

	for (int i = 0; i < str_vec.size(); i++) {
		string str = str_vec[i].first;
		bool isPre = true;
		
		for (int j = i + 1; j < str_vec.size(); j++) {
			string str_cmp = str_vec[j].first;

			if (str_cmp.find(str) == 0) {
				isPre = false;
				break;
			}
		}

		if (isPre) answer++;
	}

	cout << answer << endl;
}

bool cmp(const pair<string, int>& a, const pair<string, int>& b) {
	return a.first.length() < b.first.length();
}