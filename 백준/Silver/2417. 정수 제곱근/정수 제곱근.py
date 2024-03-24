import sys
input = sys.stdin.readline

n = int(input())

q = int(n ** 0.5)

if q * q >= n:
    print(q)
else:
    print(q+1)