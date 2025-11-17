#include <bits/stdc++.h>
using namespace std;
int n, m;
int arr[9];
bool vis[9];

void dfs(int depth) {
	if(depth == m) {
		for(int i=0; i<m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	for(int i=1; i<=n; i++) {
		if(!vis[i]) {
			arr[depth] = i;
			vis[i] = true;
			dfs(depth+1);
			vis[i] = false;
		}
	}
}

int main(int argc, char** argv)
{   
	/*
		수열
	*/ 
	cin >> n >> m;
	dfs(0);
	return 0;
}