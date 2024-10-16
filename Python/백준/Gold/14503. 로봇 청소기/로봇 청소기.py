from collections import deque

n, m = map(int, input().split())
r, c, d = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

visited[r][c] = 1
cnt = 1

def turn_left(d):
    return (d - 1) % 4

def bfs(r, c, d):
    global cnt
    queue = deque()
    queue.append((r, c, d))

    while queue:
        x, y, d = queue.popleft()
        turned = 0 

        if visited[x][y] == 0:
            visited[x][y] = 1
            cnt += 1

        for _ in range(4):
            d = turn_left(d)
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0 and graph[nx][ny] == 0:
                queue.append((nx, ny, d))
                visited[nx][ny] = 1
                cnt += 1
                turned = 1
                break

        if not turned:
            nx = x - dx[d]
            ny = y - dy[d]

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                queue.append((nx, ny, d))
            else:
                break

bfs(r, c, d)
print(cnt)