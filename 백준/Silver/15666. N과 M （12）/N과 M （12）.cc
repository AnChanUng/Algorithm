#include <bits/stdc++.h>
using namespace std;
int n, m, nn;
int arr[10];
bool vis[10];
vector<int> v;
/*
    중복 제거 조합
*/

void dfs(int depth, int start) {
    if(depth == m) {
        for(int i=0; i<m; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    int used = INT_MIN;

    for(int i=start; i<n; i++) {
        if(used != v[i]) {
            arr[depth] = v[i];
            used = v[i];
            dfs(depth+1, i);
        }    
    }
}

int main() {
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> nn;
        v.push_back(nn);
    }
    sort(v.begin(), v.end());
    dfs(0, 0);
    return 0;
}