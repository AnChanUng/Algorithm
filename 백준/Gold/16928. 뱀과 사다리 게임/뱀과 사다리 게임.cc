#include <bits/stdc++.h>
using namespace std;
int n, m;
int x, y, u, v;
int dist[101];
bool vis[101];
int sadari[101];
int bam[101];
int main() {
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        cin >> x >> y;
        sadari[x] = y;
    }
    for(int i=0; i<m; i++) {
        cin >> u >> v;
        bam[u] = v;    
    }
    queue<int> q;
    vis[0] = true;
    q.push(1);
    dist[1] = 0;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(cur == 100) {
            cout << dist[cur];
            return 0;
        }
        for(int dice=1; dice<=6; dice++) {
            int nx = cur + dice;
            if(nx > 101) continue;
            if(sadari[nx]) nx = sadari[nx];
            if(bam[nx]) nx = bam[nx];
            if(!vis[nx]) {
                vis[nx] = true;
                dist[nx] = dist[cur] + 1;
                q.push(nx);
            }
        }
    }
}