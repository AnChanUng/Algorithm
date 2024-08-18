n = int(input())
number = int(input())

graph = [[] for _ in range(n+1)]
for _ in range(number):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

cnt = 0
visited = [False] * (n+1)

def dfs(x):
    global cnt
    visited[x] = True
    for i in graph[x]:
        if not visited[i]:
            dfs(i)
            cnt += 1
dfs(1)
print(cnt)