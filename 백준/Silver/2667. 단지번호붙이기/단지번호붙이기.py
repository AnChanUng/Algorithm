n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

home = 0
def dfs(x, y):
    global home
    if x <= - 1 or y <= -1 or x >= n or y >= n:
        return False

    if graph[x][y] == 1:
        # 해당노드 방문처리
        home += 1
        graph[x][y] = 0
        dfs(x, y+1)
        dfs(x, y-1)
        dfs(x-1, y)
        dfs(x+1, y)
        return True
    else:
        False

houses = []
for i in range(n):
    for j in range(n):
        if dfs(i, j) == True:
            houses.append(home)
            home = 0

houses.sort()

print(len(houses))
for i in houses:
    print(i)