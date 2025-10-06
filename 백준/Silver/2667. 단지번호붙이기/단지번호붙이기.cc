#include <bits/stdc++.h>
using namespace std;
int n;
char graph[26][26];
bool vis[26][26];
vector<int> v;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
#define X first
#define Y second

int dfs(int x, int y) {
    vis[x][y] = true;
    int cnt = 1;
    
    for(int dir=0; dir<4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        if(!vis[nx][ny] && graph[nx][ny] == '1') {
            cnt += dfs(nx, ny);
        }
    }
    return cnt;
}

int main() {
    cin >> n;
    for(int i=0; i<n; i++) {
        cin >> graph[i];
    }
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(graph[i][j] == '1' && !vis[i][j]) {
                int cnt = dfs(i, j);
                v.push_back(cnt);
            }
        }
    }
    sort(v.begin(), v.end());
    cout << v.size() << "\n";
    for(int i=0; i<v.size(); i++) {
        cout << v[i] << "\n";
    }
}