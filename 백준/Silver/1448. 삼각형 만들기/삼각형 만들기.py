import sys
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
    sam = int(input())
    array.append(sam)

array.sort(reverse=True)

for i in range(n-2):
    if array[i] < array[i+1] + array[i+2]:
        result = array[i] + array[i+1] + array[i+2]
        break
    else:
        result = -1

print(result)