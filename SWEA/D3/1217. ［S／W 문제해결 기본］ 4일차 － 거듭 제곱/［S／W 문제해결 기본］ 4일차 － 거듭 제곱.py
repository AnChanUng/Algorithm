for test_case in range(1, 11):
    t = int(input())
    n, m = map(int, input().split())

    print(f'#{test_case}', n ** m)