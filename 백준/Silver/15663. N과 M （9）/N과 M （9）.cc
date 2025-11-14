#include <bits/stdc++.h>
using namespace std;
int n, m, nn;
int arr[10];
bool vis[10];
vector<int> v;

void dfs(int depth) {
    if(depth == m) {
        for(int i=0; i<m; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    int used = INT_MIN;

    for(int i=0; i<n; i++) {
        if(!vis[i] && used != v[i]) {
            vis[i] = true;
            arr[depth] = v[i];
            used = v[i];
            dfs(depth+1);
            vis[i] = false;
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
    dfs(0);
    return 0;
}