n = int(input())
array = []
ranks = []
for _ in range(n):
    kg, key = map(int, input().split())
    array.append((kg, key))

for i in range(n):
    rank = 1
    for j in range(n):
        if i != j:
            if array[i][0] < array[j][0] and array[i][1] < array[j][1]:
                rank += 1
    ranks.append(rank)

print(*ranks)