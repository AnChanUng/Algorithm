#include <bits/stdc++.h>
using namespace std;
int n, m;
int nn;
int arr[10];
bool visited[10];
vector<int> v;

void dfs(int depth) {
    if(depth == m) {
        for(int i=0; i<m; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for(int i=0; i<n; i++) {
        if(!visited[i]) {
            visited[i] = true;
            arr[depth] = v[i];
            dfs(depth+1);
            visited[i] = false;
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