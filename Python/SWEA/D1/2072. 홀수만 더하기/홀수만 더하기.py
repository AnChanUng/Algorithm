t = int(input())

for test_case in range(1, t+1):
    numbers = list(map(int, input().split()))
    res = 0
    for i in numbers:
        if i % 2 == 1:
            res += i

    print(f'#{test_case} {res}')