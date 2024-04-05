n, k = map(int, input().split())
coins = []
for _ in range(n):
    price = int(input())
    coins.append(price)

coins.sort(reverse=True)

cnt = 0
for i in coins:
    if k >= i:
        cnt += k//i
        k %= i

print(cnt)