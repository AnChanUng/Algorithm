import sys
input = sys.stdin.readline

def dfs(graph, v, visited):
    global cnt
    visited[v] = True

    for i in graph[v]:
        if not visited[i]:
            cnt += 1
            dfs(graph, i, visited)

number = int(input())
network = int(input())

graph = [[] for _ in range(number+1)]
visited = [False] * (number + 1)
cnt = 0

for i in range(network):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(graph, 1, visited)
print(cnt)