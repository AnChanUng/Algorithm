n = int(input())
a = list(map(int, input().split()))

dp = [0] * 1001

for i in range(n):
    dp[i] = a[i]

for i in range(1, n):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i], dp[j] + a[i])

print(max(dp))
