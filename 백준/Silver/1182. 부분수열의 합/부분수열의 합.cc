#include <bits/stdc++.h>
using namespace std;
int n, s, nn;
vector<int> v;
int cnt;

void dfs(int idx, int sum) {
	if(idx == n) {
		if(sum == s) {
			cnt++;
		}
		return;
	}
	dfs(idx+1, sum+v[idx]);
	dfs(idx+1, sum);
}

int main(int argc, char** argv)
{   
	cin >> n >> s;
	for(int i=0; i<n; i++) {
		cin >> nn;
		v.push_back(nn);
	}
	cnt = 0;
	dfs(0, 0);
	if(s == 0) cnt--;
	cout << cnt;
	return 0;
}