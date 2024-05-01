t = int(input())
for i in range(1, t+1):
    p, q, r, s, w = map(int, input().split())

    A_work = w * p

    if w <= r:
        B_work = q
    else:
        B_work = q + (w-r) * s

    if A_work < B_work:
        print(f'#{i}', A_work)
    elif A_work > B_work:
        print(f'#{i}', B_work)
