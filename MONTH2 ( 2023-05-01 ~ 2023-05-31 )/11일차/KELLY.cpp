/*
	Baekjoon 보물 (1026)
*/

#include <iostream>

#include <vector>
#include <algorithm>

using namespace std;

bool sort_desc_proc(int a, int b);
int main() {
	/**
	첫째 줄에 N이 주어진다. 
	둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 
	셋째 줄에는 B에 있는 수가 순서대로 주어진다. 
	
	N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
	*/
	int result = 0;

	int N = 0; cin >> N;
	vector<int> A, B;

	// A 입력받기
	for (int i = 0; i < N; i++) {
		int n = 0; cin >> n;
		A.push_back(n);
	}

	// B 입력받기
	for (int i = 0; i < N; i++) {
		int n = 0; cin >> n;
		B.push_back(n);
	}

	// A 오름차순 정렬
	sort(A.begin(), A.end());
	// B 내림차순 정렬
	sort(B.begin(), B.end(), sort_desc_proc);


	// S = A[0] × B[0] + ... + A[N-1] × B[N-1]
	for (int i = 0; i < N; i++) {
		result += A[i] * B[i];
	}

	// 출력
	cout << result << endl;
}

bool sort_desc_proc(int a, int b) {
	return a > b;
}