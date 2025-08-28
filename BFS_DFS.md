### DFS(Depth-First Search, 깊이 우선 탐색)
> 다차원 배열에서 각 칸을 방문할 때 깊이를 우선으로 방문하는 알고리즘 (스택, 재귀)
1. 시작하는 칸을 스택에 넣고 방문했다는 표시를 남김
2. 스택에서 원소를 꺼내어 그 칸과 상하좌우로 인접한 칸에 대해 3번을 진행
3. 해당 칸을 이전에 방문했다면 아무 것도 하지 않고, 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 스택에 삽입
4. 스택이 빌 때 까지 2번을 반복

### BFS(Breadth-First Search, 너비 우선 탐색)
> 다차원 배열에서 각 칸을 방문할 때 너비를 우선으로 방문하는 알고리즘 (큐)
1. 시작하는 칸을 큐에 넣고 방문했다는 표시를 남김
2. 큐에서 원소를 꺼내어 그 칸에 상하좌우로 인접한 칸에 대해 3번을 진행
3. 해당 칸을 이전에 방문했다면 아무 것도 하지 않고, 처음으로 방문했다면 방문했다는 표시를 남기고 해당 칸을 큐에 삽입
4. 큐가 빌 때까지 2번을 반복

### BFS 유형
- 거리 측정: 미로탐색 (2178)
- 시작점아 여러 개    (7576)
- 시작점이 두 종류    (4179)
- 1차원에서의 BFS     (1697)
```
#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int board[502][502];
bool vis[502][502];
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m;

int main(void) {
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> board[i][j];
        }
    }
    int mx = 0;
    int num = 0;
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(vis[i][j] || board[i][j] == 0) continue;
            num++;
            queue<pair<int, int>> q;
            vis[i][j] = 1;
            q.push({i, j});
            int area = 0;
            while(!q.empty()) {
                area++;
                pair<int, int> cur = q.front(); q.pop();
                for(int dir=0; dir<4; dir++) {
                     int nx = cur.X + dx[dir];
                     int ny = cur.Y + dy[dir];
                     if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                     if(vis[nx][ny] || board[nx][ny] != 1) continue;
                     vis[nx][ny] = 1;
                     q.push({nx, ny});
                }                   
            }
            mx = max(mx, area);
        }
    }
}
```
### Backtracking
불필요한 탐색을 하지 않고, 이전 단계로 돌아와 다른 후보해를 탐색해 나가는 방법
