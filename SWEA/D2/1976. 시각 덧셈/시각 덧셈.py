t = int(input())
for i in range(1, t+1):
    m1, d1, m2, d2 = map(int, input().split())

    if m1+m2 > 12:
        if d1+d2 >= 60:
            m, d = m1+m2+1-12, d1+d2-60
        else:
            m, d = m1+m2-12, d1+d2
    else:
        if d1+d2 >= 60:
            m, d = m1+m2+1, d1+d2-60
        else:
            m, d = m1+m2, d1+d2

    print(f'#{i}', m, d)
