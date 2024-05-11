import sys
input = sys.stdin.readline
from itertools import permutations

n = list(input().strip())
n.sort(reverse=True)
temp = ""
for i in range(len(n)):
    temp += n[i]

temp = int(temp)

if temp % 10 != 0 or temp % 3 != 0:
    print(-1)
else:
    print(temp)