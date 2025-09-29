#include <bits/stdc++.h>
using namespace std;
int dist[100002];
int n, k;
int main() {
    cin >> n >> k;
    fill(dist, dist+100002, -1);
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(cur == k) {
            break;
        }
        int nx = cur * 2;
        if(nx <= 100002 && dist[nx] == -1) {
            dist[nx] = dist[cur];
            q.push(nx);
        }
        
        for(int nx : {cur-1, cur+1}) {
            if(nx < 0 || nx > 100002) continue;
            if(dist[nx] == -1) {
                q.push(nx);
                dist[nx] = dist[cur] + 1;
            }
        }
    }
    cout << dist[k];
}