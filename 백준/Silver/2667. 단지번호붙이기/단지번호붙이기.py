n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dfs(x, y):
    
    if x < 0 or y < 0 or x >= n or y >= n:
        return False
    
    if graph[x][y] == 1:
        global cnt
        cnt += 1
        graph[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            dfs(nx, ny)
        return True
    return False
        
cnt = 0
result = 0
array = []
for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            array.append(cnt)
            result += 1
            cnt = 0

array.sort()
print(result)
for i in range(len(array)):
    print(array[i])