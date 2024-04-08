import sys
input = sys.stdin.readline

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

n = int(input())
a_list = list(map(int, input().split()))

sosu = []
for num in a_list:
    if is_prime(num):
        sosu.append(num)

result = 1
for i in sosu:
    result *= i

if len(sosu) == 0:
    print(-1)
else:
    result = sosu[0]
    for i in sosu[1:]:
        result = lcm(result, i)
    print(result)