#include <bits/stdc++.h>
using namespace std;
int graph[10][10];
vector<pair<int, int>> blanks;
bool finish = false;

bool isValid(int x, int y, int num) {
    // 가로 체크
    for(int j=0; j<9; j++) {
        if(graph[x][j] == num) {
            return false;
        }
    }
    // 세로 체크
    for(int i=0; i<9; i++) {
        if(graph[i][y] == num) {
            return false;
        }
    }
    
    // 3x3 체크
    int sx = (x/3) * 3;
    int sy = (y/3) * 3;
    for(int i=sx; i<sx+3; i++) {
        for(int j=sy; j<sy+3; j++) {
            if(graph[i][j] == num) {
                return false;
            }
        }
    }
    return true;
}

void dfs(int idx) {
    if(finish) return;

    if(idx == blanks.size()) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                cout << graph[i][j] << " ";
            }
            cout << "\n";
        }
        finish = true;
        return;
    }
    int x = blanks[idx].first;
    int y = blanks[idx].second;

    for(int num=1; num<=9; num++) {
        if(isValid(x, y, num)) {
            graph[x][y] = num;
            dfs(idx+1);
            graph[x][y] = 0;
        }
    }
}

int main() {
    for(int i=0; i<9; i++) {
        for(int j=0; j<9; j++) {
            cin >> graph[i][j];
            if(graph[i][j] == 0) {
                blanks.push_back({i, j});
            }
        }
    }
    dfs(0);
    return 0;
}