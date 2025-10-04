#include <bits/stdc++.h>
using namespace std;
int n, m;            // 사다리 수, 뱀의 수
int x, y;            // 사다리의 정보
int u, v;            // 뱀의 정보
int dist[101];       
int ladder[101];     // 사다리
int bam[101];        // 뱀
bool vis[101];       
int main() {
    cin >> n >> m;
    // 사다리 정보
    for(int i=0; i<n; i++) {
        cin >> x >> y; // x번칸 도착 y번칸 이동
        ladder[x] = y;
    }
    // 뱀의 정보
    for(int i=0; i<m; i++) {
        cin >> u >> v; // u번칸 도착하면 v번칸 이동
        bam[u] = v;
    }
    queue<int> q;
    q.push(1);
    vis[1] = true;
    dist[1] = 0;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(cur == 100) {
            cout << dist[cur];
            return 0;
        }
        for(int dice=1; dice<=6; dice++) {
            int nx = cur + dice; 
            if(nx > 100) continue;
            if(ladder[nx]) nx = ladder[nx];
            if(bam[nx]) nx = bam[nx];
            if(!vis[nx]) {
                vis[nx] = true;
                dist[nx] = dist[cur] + 1;
                q.push(nx);
            }
        }
    }
}