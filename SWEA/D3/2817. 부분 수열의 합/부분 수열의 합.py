from itertools import combinations

t = int(input())
for test_case in range(1, t+1):
    n, k = map(int, input().split())
    array = list(map(int, input().split()))

    cnt = 0
    for r in range(1, n+1):
        for i in combinations(array, r):
            if sum(i) == k:
                cnt += 1

    print(f'#{test_case}', cnt)
