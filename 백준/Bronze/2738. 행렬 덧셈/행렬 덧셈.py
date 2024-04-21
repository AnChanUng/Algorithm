n, m = map(int, input().split())
array = []
for _ in range(n):
    a = list(map(int, input().split()))
    array.append(a)
array1 = []
for _ in range(n):
    b = list(map(int, input().split()))
    array1.append(b)

for i in range(n):
    for j in range(m):
        result = array[i][j] + array1[i][j]

        print(result, end=" ")
    print()
