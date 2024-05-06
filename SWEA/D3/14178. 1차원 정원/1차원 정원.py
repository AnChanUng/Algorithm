t = int(input())
for test_case in range(1, t+1):
    n, d = map(int, input().split())
    array = []
    for a in range(1, n+1):
        array.append(a)

    if n % (2*d+1) == 0:
        print(f'#{test_case}', n // (2*d+1))
    else:
        print(f'#{test_case}', n // (2*d+1) + 1)