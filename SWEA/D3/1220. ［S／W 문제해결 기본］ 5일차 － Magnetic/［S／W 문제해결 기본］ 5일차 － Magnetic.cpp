#include <bits/stdc++.h>
using namespace std;
int n;
int answer;
bool colCheck[20];
bool diag1[40];
bool diag2[40];
/*
    문제
    

    접근 방식
    
*/

int main() {
    int T;
    //cin >> T;

    for(int test_case=1; test_case<=10; test_case++) {
        int n;
		cin >> n;

		vector<vector<int>> graph(n, vector<int>(n));

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				cin >> graph[i][j];
			}
		}
		int answer = 0;

		for(int col=0; col<n; col++) {
			bool hasN = false;
			for(int row=0; row<n; row++) {
				if(graph[row][col] == 1) {
					hasN = true;
				} else if (graph[row][col] == 2) {
					if(hasN) {
						answer++;
						hasN = false;
					}
				}
			}
		}
		cout << "#" << test_case << " " << answer << "\n";
    }
    return 0;
}