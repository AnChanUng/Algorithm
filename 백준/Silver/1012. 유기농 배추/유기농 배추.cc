#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int t, m, n, k;
int a, b;
int main() {
    cin >> t;
    for(int test=0; test<t; test++) {
        cin >> m >> n >> k; 
        int board[52][52];
        int vis[52][52];
        memset(board, 0, sizeof(board));
        memset(vis, 0, sizeof(vis));
        for(int i=0; i<k; i++) {
            cin >> a >> b;
            board[b][a] = 1;
        }
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1 && vis[i][j] == false) {
                    cnt++;
                    vis[i][j] = true;
                    queue<pair<int, int>> q;
                    q.push({i, j});
                    while(!q.empty()) {
                        auto cur = q.front(); q.pop();
                        for(int dir=0; dir<4; dir++) {
                            int nx = cur.X + dx[dir];
                            int ny = cur.Y + dy[dir];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(vis[nx][ny] == false && board[nx][ny] == 1) {
                                vis[nx][ny] = true;
                                q.push({nx, ny});
                            }
                        }
                    }
                }
            }
        }
        cout << cnt << "\n";
    }
}