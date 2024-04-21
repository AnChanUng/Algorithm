array = [list(map(int, input().split())) for _ in range(9)]

total = 0
for i in range(9):
    for j in range(9):
        total = max(array[i][j], total)

        if array[i][j] == total:
            result = [i+1, j+1]

print(total)

for i in result:
    print(i, end=" ")