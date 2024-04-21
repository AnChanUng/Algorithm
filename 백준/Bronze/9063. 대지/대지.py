n = int(input())
array = []
array1 = []
for _ in range(n):
    a, b = map(int, input().split())
    array.append(a)
    array1.append(b)

width = max(array) - min(array)
height = max(array1) - min(array1)

print(width * height)