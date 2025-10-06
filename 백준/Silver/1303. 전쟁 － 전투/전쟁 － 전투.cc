#include <bits/stdc++.h>
using namespace std;
int n, m;
int wCnt = 0, bCnt = 0;
char arr[101][101];
bool vis[101][101];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
#define X first
#define Y second

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    vis[x][y] = true;
    q.push({x, y});
    int cnt = 1;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(!vis[nx][ny] && arr[nx][ny] == arr[cur.X][cur.Y]) {
                cnt++;
                vis[nx][ny] = true;
                q.push({nx, ny});
            }
        }
    }
    if(arr[x][y] == 'W') {
        wCnt += cnt * cnt;
    } else {
        bCnt += cnt * cnt;
    }
}

int main() {
    cin >> n >> m; // 가로, 세로
    for(int i=0; i<m; i++) {
        cin >> arr[i];
    }
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(!vis[i][j] && arr[i][j]) {
                bfs(i, j);
            }
        }
    }
    cout << wCnt << " " << bCnt;
}