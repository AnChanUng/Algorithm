n, m = map(int, input().split()) # 얼음 틀의 세로길이 가로길이
# 구멍이 뚫려있으면 0 아니면 1
# 한번에 만들 수 있는 아이스크림의 개수 출력
graph = []
for i in range(n): # -> 그래프로 일단 만들자
    graph.append(list(map(int, input())))

def dfs(x, y):
    if x<=-1 or x>=n or y<=-1 or y>=m: # 범위가 벗어나면 false
        return False
    
    if graph[x][y] == 0: # 모든 0을 1로 바꾸면서 하나의 덩어리로 인식함
        graph[x][y] = 1
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)    