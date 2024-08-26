import sys
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
    data = input().split()
    data[1] = int(data[1])
    data[2] = int(data[2])
    data[3] = int(data[3])
    array.append(data)
    
array.sort(key=lambda x: (-x[1], x[2], -x[3], x[0]))

for i in range(len(array)):
    print(array[i][0])