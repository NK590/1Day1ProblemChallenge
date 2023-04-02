/**
 * @file P_160585.cpp
 * @author KELLY (rhd5656@gmail.com)
 * @brief Programmers 혼자서 하는 틱택토(160585)
 * @version 0.1
 * @date 2023-04-02
 * 
 * @copyright Copyright (c) 2023
 * 
 */

#include <iostream>

#include <string>
#include <vector>

using namespace std;

int solution(vector<string> board);

int solution(vector<string> board) {
	int O_num = 0;
	int X_num = 0;
	int O_win_num = 0;
	int X_win_num = 0;
	vector<vector<int>> chkWinVec = {{0,1,2}, {3,4,5}, {6,7,8}, {0,4,8}, {2, 4, 6}, {0, 3, 6}, {1,4,7}, {2, 5,8}};
	// vector<vector<int>> chkWinExpVec = {{0,5}, {0,}, {0, }}
	vector<vector<int>> locVec = {{0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
	vector<vector<string>> boardVec = {{".",".","."},{".",".","."},{".",".","."}};

	// vector에 다시담기
	for(int i = 0; i < board.size(); i++) {
		boardVec[locVec[(i * 3)][0]][locVec[(i * 3)][1]] = board[i][0];
		boardVec[locVec[(i * 3) + 1][0]][locVec[(i * 3) + 1][1]] = board[i][1];
		boardVec[locVec[(i * 3) + 2][0]][locVec[(i * 3) + 2][1]] = board[i][2];
	}

	// for(vector<string> boardV : boardVec) {
	// 	for(string b : boardV) {
	// 		cout << b << " ";
	// 	}
	// 	cout << endl;
	// }

	// 갯수 체크
	// 갯수가 같거나 O가 하나더 많거나 X가 하나더 적거나
	for(vector<string> boardV : boardVec) {
		for(string ch : boardV) {
			if(ch == "O") O_num++;
			if(ch == "X") X_num++;
		}
	}

	if(
		!(
			O_num == X_num
			|| ((O_num - X_num) == 1)
		)
	) {
		return 0;
	}
	
	// 게임종료 체크
	for(vector<int> chkWin : chkWinVec) {
		bool isWin = true;
		string ch = ""; 
		
		for(int loc : chkWin) {
			string tmp = boardVec[locVec[loc][0]][locVec[loc][1]];
			if(ch == "") ch = tmp;
			else {
				if(tmp == ch) continue;
				else {
					isWin = false;
					break;
				}
			}
		}

		if(ch != "." && isWin) {
			if(ch == "O") O_win_num++;
			if(ch == "X") X_win_num++;
		}
	}

	// if(O_win_num > 1) { return 0; }
	// if(X_win_num > 1) { return 0; }
	// if(O_win_num == 1 && X_win_num == 1) { return 0; }
	if(O_win_num >= 1 && X_win_num >= 1) { return 0; }


	// 갯수 & 게임종료 체크
	// O가 이겼을 경우 X가 하나더 많을 수 없습니다. X가 이겼을 경우 O가 하나더 많을 수 없습니다.
	if(O_win_num >= 1) {
		if(O_num != X_num + 1) {
			return 0;
		}
	}
	if(X_win_num >= 1) {
		if(O_num != X_num) {
			return 0;
		}
	}
	if(O_num + X_num == 9) {
		if(O_num != X_num + 1) {
			return 0;
		}
	}

    return 1;
}

int main() {
	vector<string> board = {
		"...", 
		"...", 
		"O.."
	};
	cout << solution(board) << endl;
}