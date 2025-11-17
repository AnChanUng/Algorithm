#include <bits/stdc++.h>
using namespace std;
int n, m;
int arr[9];
/*
	중복 있는 조합
*/

void dfs(int depth, int start) {
	if(depth == m) {
		for(int i=0; i<m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	for(int i=start; i<=n; i++) {
		arr[depth] = i;
		dfs(depth+1, i);
	}
}

int main(int argc, char** argv)
{   
	cin >> n >> m;
	dfs(0, 1);
	return 0;
}