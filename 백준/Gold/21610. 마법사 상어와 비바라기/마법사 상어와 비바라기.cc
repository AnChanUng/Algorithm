#include <bits/stdc++.h>
using namespace std;
int n, m, nn;
int d, s;
int graph[51][51];
int dx[9] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
int dy[9] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
vector<pair<int, int>> clouds;

int main() {
    cin >> n >> m;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> graph[i][j];
        }
    }
    clouds.push_back({n - 1, 0});
    clouds.push_back({n - 1, 1});
    clouds.push_back({n - 2, 0});
    clouds.push_back({n - 2, 1});
    
    for(int i=0; i<m; i++) {
        cin >> d >> s;
        s %= n;

        // 구름 이동
        vector<pair<int, int>> newClouds;
        vector<vector<bool>> wasCloud(n, vector<bool>(n, false));

        for(auto [x, y] : clouds) {
            int nx = (x + dx[d] * s + n * 50) % n;
            int ny = (y + dy[d] * s + n * 50) % n;
            graph[nx][ny] += 1;
            newClouds.push_back({nx, ny});
            wasCloud[nx][ny] = true;
        }
        // 물복사 마법
        int diagx[4] = {-1, -1, 1, 1};
        int diagy[4] = {-1, 1, -1, 1};
        
        for(auto [x, y] : newClouds) {
            int cnt = 0;
            for(int d=0; d<4; d++) {
                int nx = x + diagx[d];
                int ny = y + diagy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(graph[nx][ny] > 0) cnt++;
            }
            graph[x][y] += cnt;
        }
        clouds.clear();
        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(graph[x][y] >= 2 && !wasCloud[x][y]) {
                    clouds.push_back({x, y});
                    graph[x][y] -= 2;
                } 
            }
        }
    }     
    int res = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            res += graph[i][j];
        }
    }
    cout << res;
}