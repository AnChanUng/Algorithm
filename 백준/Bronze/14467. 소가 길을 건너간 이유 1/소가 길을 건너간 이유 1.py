n = int(input())
array = []
for _ in range(n):
    cow_number, witch = map(int, input().split())
    array.append([cow_number, witch])

cnt = 0
for i in range(n):
    for j in range(i+1, n):
        if array[i][0] == array[j][0]:
            if abs(array[i][1]-array[j][1]) == 0:
                break
            if abs(array[i][1]-array[j][1]) == 1:
                cnt += 1
                break

print(cnt)