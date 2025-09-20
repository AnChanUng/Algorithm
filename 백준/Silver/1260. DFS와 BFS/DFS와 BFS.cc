#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int graph[1002][1002];
int vis[1002];
int n, m, v;
int a, b;

void dfs(int start) {
    vis[start] = true;
    cout << start << " ";
    for(int i=1; i<=n; i++) {
        if(graph[start][i] == 1 && vis[i] == false) {
            dfs(i);
        }
    }
}

void bfs(int start) {
    fill(vis, vis+n+1, 0);
    queue<int> q;
    vis[start] = true;
    q.push(start);
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        cout << cur << " ";
        for(int i=1; i<=n; i++) {
            if(graph[cur][i] && vis[i] == false) {
                vis[i] = true;
                q.push(i);
            }
        }
    }
}

int main(void) {
    cin >> n >> m >> v; // 정점, 간선, 정점의 번호

    for(int i=0; i<m; i++) {
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }
    dfs(v);
    cout << "\n";
    bfs(v);
}