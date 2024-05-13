n = int(input())
array = []
cnt = 0
for i in range(n):
    score = int(input())
    array.append(score)

for i in range(n-1, 0, -1):
    if array[i] <= array[i-1]:
        cnt += (array[i-1] - array[i] + 1)
        array[i-1] = array[i] - 1

print(cnt)