#include <bits/stdc++.h>
using namespace std;
int n, k;
int dist[100001];
int cnt[100001];
int main() {
    cin >> n >> k;
    fill(dist, dist+100001, -1);
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    cnt[n] = 1;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(cur == k) break;
        for(int nx : {cur-1, cur+1, cur*2}) {
            if(nx < 0 || nx > 100001) continue;
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