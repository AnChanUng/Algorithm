import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = [list(input()) for _ in range(n)]

size = min(n, m)
for k in range(size, 0, -1):
    for i in range(n):
        for j in range(m):
            if ((i+k) < n) and ((j+k) < m) and (array[i][j] == array[i][j+k] == array[i+k][j] == array[i+k][j+k]):
                print((k+1)**2)
                exit()

else:
    print(1)
