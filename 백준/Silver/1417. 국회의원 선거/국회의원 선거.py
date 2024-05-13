n = int(input())
cnt = 0
array = []
for _ in range(n):
    array.append(int(input()))

while array.index(max(array)) != 0:
    array[array.index(max(array))] -= 1
    array[0] += 1
    cnt += 1

for i in range(1, n):
    if array[0] == array[i]:
        array[i] -= 1
        array[0] += 1
        cnt += 1

print(cnt)