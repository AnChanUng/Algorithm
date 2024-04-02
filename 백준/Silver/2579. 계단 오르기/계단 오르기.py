n = int(input())

dp = [0] * (n + 1)
step = []
for i in range(n):
    step.append(int(input()))

dp[0] = 0
dp[1] = step[0]
if n > 1:
    dp[2] = step[0] + step[1]

for i in range(3, n + 1):
    dp[i] = max(dp[i-3] + step[i-2] + step[i-1], dp[i-2] + step[i-1])

print(dp[n])