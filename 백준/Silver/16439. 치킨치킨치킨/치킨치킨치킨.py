from itertools import combinations

n, m = map(int, input().split())
likes = [list(map(int, input().split())) for _ in range(n)]
max_sum = 0

for a, b, c in combinations(range(m), 3):
    sum = 0
    for i in range(n):
        sum += max(likes[i][a], likes[i][b], likes[i][c])
    max_sum = max(max_sum, sum)

print(max_sum)