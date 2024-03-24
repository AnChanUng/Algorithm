# S : 신맛->곱
# B : 쓴맛->합
# N : 재료개수
# 출력: 신맛 - 쓴맛
from itertools import combinations
import sys
input = sys.stdin.readline

N = int(input())
s_array = []
b_array = []
for _ in range(N):
    S, B = map(int, input().split())
    s_array.append(S)
    b_array.append(B)

diff = float('inf')

for i in range(1, N+1):
    idxs = list(combinations(list(range(N)), i))
    for food in idxs:
        s = 1
        b = 0
        for j in range(i):
            s *= s_array[food[j]]
            b += b_array[food[j]]
        if abs(s - b) < diff:
            diff = abs(s - b)

print(diff)
