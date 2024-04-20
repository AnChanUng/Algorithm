from itertools import combinations

t = int(input())

for _ in range(t):
    n = int(input())
    clothes = {}
    result = 1
    for _ in range(n):
        name, type = input().split()
        if type in clothes:
            clothes[type] += 1
        else:
            clothes[type] = 1

    for i in clothes:
        result = result * (clothes[i] + 1)

    print(result-1)
