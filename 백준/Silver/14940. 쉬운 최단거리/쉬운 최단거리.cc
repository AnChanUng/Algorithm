#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int graph[1002][1002];
int dist[1002][1002];
int n, m;
int main() {
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> graph[i][j];
        }
    }
    for(int i=0; i<n; i++) {
        fill(dist[i], dist[i]+m, -1);
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(graph[i][j] == 2) {
                queue<pair<int, int>> q;
                dist[i][j] = 0;
                q.push({i, j});
                while(!q.empty()) {
                    auto cur = q.front(); q.pop();
                    for(int dir=0; dir<4; dir++) {
                        int nx = cur.X + dx[dir];
                        int ny = cur.Y + dy[dir];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(graph[nx][ny] == 1 && dist[nx][ny] == -1) {
                            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                            q.push({nx, ny});
                        } 
                    }
                }
            }
        }
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(graph[i][j] == 0) {
                cout << 0 << " ";
            } else {
                cout << dist[i][j] << " ";
            }
        }
        cout << "\n";
    }
}