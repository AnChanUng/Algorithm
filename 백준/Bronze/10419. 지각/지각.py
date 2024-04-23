t = int(input())
for _ in range(t):
    d = int(input())
    s = 0

    while s+s**2 <= d:

        s += 1

    print(s-1)