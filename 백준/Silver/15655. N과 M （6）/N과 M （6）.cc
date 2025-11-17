#include <bits/stdc++.h>
using namespace std;
int n, m, nn;
vector<int> v;
int arr[9];
/*
	중복 없는 조합
*/
void dfs(int depth, int start) {
	if(depth == m) {
		for(int i=0; i<m; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}
	for(int i=start; i<n; i++) {
		arr[depth] = v[i];
		dfs(depth+1, i+1);
	}
}

int main(int argc, char** argv)
{   
	cin >> n >> m;
	for(int i=0; i<n; i++) {
		cin >> nn;
		v.push_back(nn);
	}
	sort(v.begin(), v.end());
	dfs(0, 0);
	return 0;
}