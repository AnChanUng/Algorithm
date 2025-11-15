#include <bits/stdc++.h>
using namespace std;
int n, s, nn;
int arr[21];
int cnt = 0;
vector<int> v;
/*
    dfs(idx, 현재합)

    문제
    1. idx == n이면 합 확인 후 return;
    2. 이 원소를 더함 -> dfs(idx+1, 현재합 + v[idx])
    3. 이 원소를 더하지 않음 -> dfs(idx+1, 현재합)
*/

void dfs(int idx, int sum) {
    if(idx == n) {
        if(sum == s) { cnt++; }
        return;
    }
    dfs(idx+1, sum + v[idx]);
    dfs(idx+1, sum);
}

int main() {
    cin >> n >> s;
    for(int i=0; i<n; i++) {
        cin >> nn;
        v.push_back(nn);
    }
    sort(v.begin(), v.end());
    dfs(0, 0);
    if(s == 0) cnt--;
    cout << cnt;
    return 0;
}