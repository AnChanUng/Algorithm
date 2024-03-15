import sys
input = sys.stdin.readline

n = int(input())

arr = []
for _ in range(n):
    xy = list(map(int, input().split()))
    arr.append([xy[1], xy[0]])

arr.sort()

for i in arr:
    print(i[1], i[0])