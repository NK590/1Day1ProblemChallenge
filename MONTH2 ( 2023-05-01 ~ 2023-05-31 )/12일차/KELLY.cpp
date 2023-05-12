/*
	Baekjoon 포켓몬 GO (13717)
*/

#include <iostream>

#include <vector>
#include <map>
using namespace std;
int main() {
	int t = 0; cin >> t;
	
	int sum_revolution = 0;
	int max_revolution = -1;
	string max_revolution_name = "";

	map<string, vector<int>> pokemon_map;
	while (t--) {
		string pokemon_name = ""; cin >> pokemon_name;

		vector<int> pokemon_revolution;
		int need_sweet = 0; cin >> need_sweet;
		int have_sweet = 0; cin >> have_sweet;
		pokemon_revolution.push_back(need_sweet);
		pokemon_revolution.push_back(have_sweet);

		// pokemon_map.insert({ pokemon_name, pokemon_revolution });

		// 하나씩 돌려서 진화 갯수 더하고
		// 최대갯수 구하고 최대갯수가 되면 이름 업데이트

		// for (auto pokemon : pokemon_map) {
			// string pokemon_name = pokemon.first;
			// vector<int> pokemon_revolution = pokemon.second;

			// int need_sweet = pokemon_revolution[0];
			// int have_sweet = pokemon_revolution[1];

			int revolution_num = 0;
			while (true) {
				have_sweet -= need_sweet;
				if (have_sweet < 0) break;

				revolution_num++;
				have_sweet += 2;
			}

			if (max_revolution < revolution_num) {
				max_revolution = revolution_num;
				max_revolution_name = pokemon_name;
			}

			sum_revolution += revolution_num;
		// }
	}

	cout << sum_revolution << endl;
	cout << max_revolution_name << endl;
}