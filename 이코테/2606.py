from collections import deque

n, m, v = map(int, input().split()) # 정점의 개수 / 간선의 개수 / 정점의 번호

graph = []
for _ in range(m): # 두 정점의 번호가 주어짐
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()
    
def dfs(start):
    visited[start] = True
    print(start, end = " ")
    for i in graph[start]:
        if not visited[i]:
            dfs(i)
    
def bfs(start):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)

visited = [False] * (n+1)
dfs(v)
print()

visited = [False] * (n+1)
bfs(v)