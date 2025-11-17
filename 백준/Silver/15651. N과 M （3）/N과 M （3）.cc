#include <bits/stdc++.h>
using namespace std;
int n, m;
int arr[8];
/*
	순열
*/

void dfs(int depth) {
	if(depth == m) {
		for(int i=0; i<m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	for(int i=1; i<=n; i++) {
		arr[depth] = i;
		dfs(depth+1); 
	}
}

int main(int argc, char** argv)
{   
	cin >> n >> m;
	dfs(0);
	return 0;
}