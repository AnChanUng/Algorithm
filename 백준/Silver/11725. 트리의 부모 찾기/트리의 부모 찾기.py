from collections import deque


def bfs(graph, start):
    queue = deque([start])
    visited = [False] * (n+1)
    parent = [0] * (n+1)
    visited[start] = True
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                parent[i] = v
    return parent

n = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

parent = bfs(graph, 1)

for i in range(2, n+1):
    print(parent[i])
