#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
string board[102];
string board1[102];
bool vis[102][102];
bool vis1[102][102];
int n;

void bfs(int x, int y, char color) {
    queue<pair<int, int>> q;
    vis[x][y] = true;
    q.push({x, y});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(vis[nx][ny] == true) continue;
            if(board[nx][ny] != color) continue;
            vis[nx][ny] = true;
            q.push({nx, ny});
        }
    }
}

void bfs1(int x, int y, char color) {
    queue<pair<int, int>> q;
    vis1[x][y] = true;
    q.push({x, y});
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(vis1[nx][ny] == true) continue;
            if(board1[nx][ny] != color) continue;
            vis1[nx][ny] = true;
            q.push({nx, ny});
        }
    }
}

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> board[i];
        board1[i] = board[i];
    }

    int cnt = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(vis[i][j] == false) {
                bfs(i, j, board[i][j]);
                cnt++;
            }                                              
        }
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(board1[i][j] == 'G') {
                board1[i][j] = 'R';
            }
        }
    }
    int cnt1 = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(vis1[i][j] == false) {
                bfs1(i, j, board1[i][j]);
                cnt1++;
            }
        }
    }
    cout << cnt << " " << cnt1;
}