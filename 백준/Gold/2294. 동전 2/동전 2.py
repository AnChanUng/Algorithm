n, k = map(int, input().split())
a_list = []

dp = [10001] * (k+1)
dp[0] = 0

for i in range(n):
    a = int(input())
    a_list.append(a)

for coin in a_list:
    for i in range(coin, k+1):
        dp[i] = min(dp[i], dp[i-coin]+1)

if dp[-1] == 10001:
    print(-1)
else:
    print(dp[-1])