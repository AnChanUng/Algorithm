m = int(input())
n = int(input())
result = []
for i in range(m, n+1):
    if i ** 0.5 % 1 == 0:
        result.append(i)

if len(result) == 0:
    print(-1)
else:
    print(sum(result))
    print(min(result))