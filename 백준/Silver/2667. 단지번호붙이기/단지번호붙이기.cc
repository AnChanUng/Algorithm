#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
string board[27];
int vis[27][27];
int n;
int main(void) {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> board[i];
    }
    vector<int> maps;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int cnt = 0;
            if(board[i][j] == '1' && vis[i][j] == false) {
                int cnt = 0;
                queue<pair<int, int>> q;
                vis[i][j] = true;
                q.push({i, j});
                while(!q.empty()) {
                    auto cur = q.front(); q.pop();
                    cnt++;
                    for(int dir=0; dir<4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(board[nx][ny] == '0' || vis[nx][ny] == true) continue;
                        vis[nx][ny] = true;
                        q.push({nx, ny});
                    }
                }
                maps.push_back(cnt);
            }
        }
    }
    cout << maps.size() << "\n";
    sort(maps.begin(), maps.end());
    for(int i=0; i<maps.size(); i++) {
        cout << maps[i] << "\n";
    }
}