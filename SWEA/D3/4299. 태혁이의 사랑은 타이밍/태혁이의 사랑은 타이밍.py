t = int(input())
for test_case in range(1, t+1):
    d, h, m = map(int, input().split())
    total = m + h * 60 + d * 24 * 60

    if total >= 16511:
        total = total - 16511
    else:
        total = -1

    print(f'#{test_case}', total)