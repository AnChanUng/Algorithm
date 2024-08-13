from collections import deque
n, m = map(int, input().split())
# 괴물이 있는 부분 0 괴물이 없는 부분 1
# 탈출해보자!! -> 탈출하기 위한 최소 칸수
# 1. 그래프 만들기 -> DFS 함수 만들기 -> 출력하기
graph = [] 
for i in range(n):
    graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue
        
            if graph[nx][ny] == 0:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    
    return graph[n-1][m-1]

print(bfs(0, 0))