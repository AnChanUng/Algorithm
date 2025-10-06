#include <bits/stdc++.h>
using namespace std;
int r, c;
int cnt = 0;
char alpha[21][21];
bool used[26];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void dfs(int x, int y, int depth) {
    cnt = max(cnt, depth);
    
    for(int dir=0; dir<4; dir++) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
        if(!used[alpha[nx][ny] - 'A']) {
            used[alpha[nx][ny] - 'A'] = true;
            dfs(nx, ny, depth+1);
            used[alpha[nx][ny] - 'A'] = false;
        }
    }
}

int main() {
    cin >> r >> c;
    for(int i=0; i<r; i++) {
        cin >> alpha[i];
    }
    used[alpha[0][0] - 'A'] = true;
    dfs(0, 0, 1);
    cout << cnt;
}