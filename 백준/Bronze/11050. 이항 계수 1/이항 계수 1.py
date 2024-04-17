from itertools import combinations

n, k = map(int, input().split())

result = list(combinations(range(n), k))
print(len(result))
