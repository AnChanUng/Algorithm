#include<bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int dist[102][102];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int solution(vector<vector<int> > maps)
{
    for(int i=0; i<maps.size(); i++) {
        for(int j=0; j<maps[i].size(); j++) {
           dist[i][j] = -1; 
        }
    }
    dist[0][0] = 0;
    queue<pair<int, int>> q;    
    q.push({0, 0}); // 0, 0 ->  0, 1 -> 0, 2 -> 0, 3 -> 0, 4-> 1, 4 -> 2, 4
    while(!q.empty()) {
        auto cur = q.front(); 
        q.pop();
        for(int dir=0; dir<4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= maps.size() || ny < 0 || ny >= maps[0].size()) continue;
            if(maps[nx][ny] != 1) continue;
            if(dist[nx][ny] == -1) {
                dist[nx][ny] = dist[cur.X][cur.Y]+1;
                q.push({nx, ny});
            }
        }
    }
    
    if(dist[maps.size()-1][maps[0].size()-1] == -1) {
        return -1;
    } else {
        return dist[maps.size()-1][maps[0].size()-1]+1;
    }
}