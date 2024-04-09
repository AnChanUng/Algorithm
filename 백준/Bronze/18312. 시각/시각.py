n, k = map(int, input().split())
cnt = 0
for a in range(0, n+1):
    if a < 10:
        a = '0' + str(a)
    for b in range(0, 60):
        if b < 10:
            b = '0' + str(b)
        for c in range(0, 60):
            if c < 10:
                c = '0' + str(c)
            if str(k) in (str(a) + str(b) + str(c)):
                cnt += 1
print(cnt)