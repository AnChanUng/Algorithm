import sys
input = sys.stdin.readline

n = int(input())
strongLess = list(map(int, input().split()))

strongLess.sort()
total = 0
if n % 2 == 0:
    for i in range(len(strongLess)):
        total = max(total, strongLess[i] + strongLess[len(strongLess)-i-1])
else:
    for i in range(len(strongLess)-1):
        total = max(total, strongLess[i] + strongLess[len(strongLess)-i-2])
    total = max(strongLess[-1], total)

print(total)