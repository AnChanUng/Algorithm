#include <bits/stdc++.h>
using namespace std;
int n, m, u, v;
int ans = 0;
bool vis[1001];
vector<vector<int>> graph(n+1);
void dfs(int x) {
    vis[x] = true;
    for(int next : graph[x]) {
        if(!vis[next]) {
            dfs(next);
        }
    }
}

int main() {
    cin >> n >> m;
    graph.resize(n+1);
    
    for(int i=0; i<m; i++) {
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for(int i=1; i<=n; i++) {
        if(!vis[i]) {
            dfs(i);
            ans++;
        }
    }
    cout << ans;
}