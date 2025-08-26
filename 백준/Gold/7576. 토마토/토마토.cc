#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[1002][1002];
int dist[1002][1002];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m;
// 익은 토마토(1), 익지 않은토마토(0), 토마토가 들어있지 않은 칸(-1)
int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n; // 상자 가로 칸의 수, 상제의 세로 칸의 수
    queue<pair<int, int>> q;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> board[i][j];
            if(board[i][j] == 1) {
                q.push({i, j});
            }
            if(board[i][j] == 0) {
                dist[i][j] = -1;
            }
        }
    }
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dist[nx][ny] >= 0) continue;
            dist[nx][ny] = dist[cur.X][cur.Y]+1;
            q.push({nx, ny});
        }
    }
    int ans = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(dist[i][j] == -1) {
                cout << -1;
                return 0;
            }
            ans = max(ans, dist[i][j]);
        }
    }
    cout << ans;
}