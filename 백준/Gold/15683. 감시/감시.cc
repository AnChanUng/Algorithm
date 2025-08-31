// http://boj.kr/c961e6bf6107428caf200c11c964f9e1
#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int board1[10][10];
int board2[10][10];
int n, m;
vector<pair<int, int>> cctv;
bool OOB(int a, int b) {
    return a < 0 || a >= n || b < 0 || b >= m;
}
// (x, y)에서 dir 방향으로 진행하며 벽을 만날 때 까지 지나치는 모든 빈칸을 7로 바꿈
void upd(int x, int y, int dir) {
    dir %= 4;
    while(true) {
        x += dx[dir];
        y += dy[dir];
        if(OOB(x, y) || board2[x][y] == 6) return; // 범위를 벗어났거나 벽을 만나면 함수 탈출
        if(board2[x][y] != 0) continue; // 해당칸이 빈칸이 아니면(cctv가 있으면) continue
        board2[x][y] = 7; // 빈칸을 7로 덮음
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    int mn = INT_MAX; // 사각 지대의 최소 크기
    for(int i=0; i<n; i++ ){
        for(int j=0; j<m; j++) {
            cin >> board1[i][j];
            if(board1[i][j] != 0 && board1[i][j] != 6) {
                cctv.push_back({i, j});
            }
            if(board1[i][j] == 0) {
                mn++;;
            }
        }
    }
    // 1 << (2*cctv.size())는 4의 cctv.size()승을 의미
    for(int tmp=0; tmp<(1<<(2*cctv.size())); tmp++) { // tmp를 4진법으로 뒀을 때 각 자리수를 cctv 방향으로 생각
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                board2[i][j] = board1[i][j];
            }
        }
        int brute = tmp;
        for(int i=0; i<cctv.size(); i++) {
            int dir = brute % 4;
            brute /= 4;
            int x = cctv[i].X;
            int y = cctv[i].Y;
            if(board1[x][y] == 1) {
                upd(x, y, dir);
            } else if(board1[x][y] == 2) {
                upd(x, y, dir);
                upd(x, y, dir+2);
            } else if(board1[x][y] == 3) {
                upd(x, y, dir);
                upd(x, y, dir+1);
            } else if(board1[x][y] == 4) {
                upd(x, y, dir);
                upd(x, y, dir+1);
                upd(x, y, dir+2);
            } else { // board1[x][y] == 5
                upd(x, y, dir);
                upd(x, y, dir+1);
                upd(x, y, dir+2);
                upd(x, y, dir+3);
            }
        }
        int val = 0;
        for(int i=0; i<n; i++) 
            for(int j=0; j<m; j++) 
                val += (board2[i][j] == 0);
        mn = min(mn, val);
    }
    cout << mn;
}