#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dist[100001];
int n, k;
int main() {
    cin >> n >> k;
    fill(dist, dist+100001, -1);
    queue<int> q;
    q.push(n);
    dist[n] = 0;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        if(cur == k) break;
        for(int nx : {cur-1, cur+1, cur*2}) {
            if(nx < 0 || nx > 100000) continue;
            if(dist[nx] == -1) {
                q.push(nx);
                dist[nx] = dist[cur] + 1;
            }
        }
    }
    cout << dist[k];
}