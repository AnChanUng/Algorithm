#include <bits/stdc++.h>
using namespace std;
int dist[100002];
int cnt[100002];
int n, k;
int main(void) {
    cin >> n >> k;
    fill(dist, dist+100002, -1);
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    cnt[n] = 1;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(cur == k) break;
        for(int nx : {cur-1, cur+1, 2*cur}) {
            if(nx < 0 || nx > 100002) continue;
            if(dist[nx] == -1) {
                dist[nx] = dist[cur] + 1;
                cnt[nx] = cnt[cur];
                q.push(nx);
            } else if(dist[nx] == dist[cur] + 1) {
                cnt[nx] += cnt[cur];
            }
        }
    }
    cout << dist[k] << "\n";
    cout << cnt[k];
}