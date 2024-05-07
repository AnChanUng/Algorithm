t = int(input())
for test_case in range(1, t+1):
    l, u, x = map(int, input().split())

    if x < l:
        x = l - x
    elif x > u:
        x = -1
    else:
        x = 0

    print(f'#{test_case}', x)
