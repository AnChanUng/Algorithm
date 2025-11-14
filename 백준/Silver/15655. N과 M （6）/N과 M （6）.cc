#include <bits/stdc++.h>
using namespace std;
int n, m, nn;
int arr[10];
bool vis[10];
vector<int> v;
/*
    문제

    접근 방식
    - 
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
        if(!vis[i]) {
            vis[i] = true;
            arr[depth] = v[i];
            dfs(depth+1, i+1);
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

    dfs(0, 0);
    return 0;
}