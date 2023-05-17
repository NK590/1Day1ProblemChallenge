/*
	Baekjoon 콰트로치즈피자 (27964)
*/

#include <iostream>
#include <map>


using namespace std;
int main() {
	int num = 0; cin >> num;
	map<string, int> toppings_map;

	bool isPizza = false;

	while (num--) {
		
		string topping = ""; cin >> topping;
		string cheeseStr = "";
		if (topping.length() >= 6) {
			cheeseStr = topping.substr(topping.length() - 6, topping.length());
		}
		bool isCheese = cheeseStr == "Cheese";

		if (isCheese) {
			if (toppings_map.find(topping) == toppings_map.end()) {
				toppings_map.insert({ topping, 0 });
			}
		}

		if (toppings_map.size() == 4) {
			isPizza = true;
		}
	}

	if (isPizza) cout << "yummy" << endl;
	else cout << "sad" << endl;

}