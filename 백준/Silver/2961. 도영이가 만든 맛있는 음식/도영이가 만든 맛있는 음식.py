from itertools import combinations

n = int(input())
sm_array = []
sm2_array = []
for _ in range(n):
    sm, sm2 = map(int, input().split())
    sm_array.append(sm)
    sm2_array.append(sm2)

total = float('inf')

for i in range(1, n+1):
    idxs = list(combinations(list(range(n)), i))
    for food in idxs:
        cnt1 = 1
        cnt2 = 0
        for j in range(i):
            cnt1 = cnt1 * sm_array[food[j]]
            cnt2 = cnt2 + sm2_array[food[j]]

        if abs(cnt1-cnt2) < total:
            total = abs(cnt1-cnt2)

print(total)
