import math

n = int(input())
a_list = list(map(int, input().split()))
x = int(input())

cnt = 0
result = 0
for i in a_list:
    if math.gcd(i, x) == 1:
        cnt += 1
        result += i

print(result / cnt)