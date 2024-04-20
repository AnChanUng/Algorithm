import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())

    p = [1] * (n+1)
    for i in range(4, n+1):
        p[i] = p[i-2] + p[i-3]

    print(p[n])