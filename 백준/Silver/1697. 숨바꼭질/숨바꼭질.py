from collections import deque

def bfs():
    queue = deque()
    queue.append(n)
    while queue:
        x = queue.popleft()
        if x == k:
            print(dist[x])
            break
        for nx in (x-1, x+1, x*2):
            if 0 <= nx <= max and not dist[nx]:
                dist[nx] = dist[x] + 1
                queue.append(nx)

max = 10 ** 5
dist = [0] * (max+1)
n, k = map(int, input().split())

bfs()