n = int(input())
array = []
for i in range(n+1):
    array.append(i)

dp = [0] * 91

dp[0] = 0
dp[1] = 1
for i in range(2, n+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[n])