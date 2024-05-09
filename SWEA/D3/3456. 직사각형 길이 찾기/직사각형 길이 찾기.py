t = int(input())
for test_case in range(1, t+1):
    a, b, c = map(int, input().split())

    if a == b:
        d = c
    elif a == c:
        d = b
    elif b == c:
        d = a
    else:
        continue

    print(f'#{test_case}', d)