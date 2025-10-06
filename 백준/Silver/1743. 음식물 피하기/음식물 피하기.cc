#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int r, c;
int maxCnt = 0;
int graph[101][101];
bool vis[101][101];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
#define X first
#define Y second

int main() {
    cin >> n >> m >> k;
    for(int i=0; i<k; i++) {
        cin >> r >> c;
        graph[r-1][c-1] = 1;
    }
    // r,c 좌표에 있는 것은 = 1, 아닌건 0
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(graph[i][j] == 1) {
                queue<pair<int, int>> q;
                vis[i][j] = true;
                q.push({i, j});
                int cnt = 1;
                while(!q.empty()) {
                    auto cur = q.front(); q.pop();
                    for(int dir=0; dir<4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(!vis[nx][ny] && graph[nx][ny] == 1) {
                            cnt++;
                            vis[nx][ny] = true;
                            q.push({nx, ny});
                        }
                    }
                    maxCnt = max(maxCnt, cnt);
                }
            }
        }
    }
    cout << maxCnt;
}