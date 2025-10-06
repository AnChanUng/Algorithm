#include <bits/stdc++.h>
using namespace std;
int n, m;
string str;
bool vis[101][101];
vector<string> war;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int wCnt = 0, bCnt = 0;

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    vis[x][y] = true;
    q.push({x, y});
    int cnt = 1;
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(!vis[nx][ny] && war[nx][ny] == war[cur.first][cur.second]) {
                vis[nx][ny] = true;
                q.push({nx, ny});
                cnt++;
            }
        }
    }
    if(war[x][y] == 'W') {
        wCnt += cnt * cnt;
    } else {
        bCnt += cnt * cnt;
    }
}

int main() {
    cin >> n >> m; 
    
    for(int i=0; i<m; i++) {
        cin >> str;
        war.push_back(str);
    }
    
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            if(!vis[i][j]) {
                bfs(i, j);
            }
        }
    }
    cout << wCnt << " " << bCnt;
}