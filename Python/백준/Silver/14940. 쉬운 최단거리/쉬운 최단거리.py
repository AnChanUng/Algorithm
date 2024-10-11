from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    visited = [[0] * m for _ in range(n)]
    visited[x][y] = 1
    result[x][y] = 0

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
    
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and graph[nx][ny] == 1:
                visited[nx][ny] = 1
                result[nx][ny] = result[x][y] + 1
                queue.append((nx, ny))

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
result = [[-1] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            bfs(i, j)
            break

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            result[i][j] = 0

for i in range(n):
    for j in range(m):
        print(result[i][j], end = " ")
    print()