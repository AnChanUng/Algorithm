n = int(input())

def factorial(n):
    if n == 0:
        return 1
    else:
        return factorial(n-1) * n

res = factorial(n)
cnt = 0
for _ in range(len(str(res))):
    if res % 10 == 0:
        cnt += 1
        res //= 10

print(cnt)