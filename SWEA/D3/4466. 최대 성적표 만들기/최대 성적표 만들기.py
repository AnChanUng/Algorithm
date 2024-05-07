t = int(input())
for test_case in range(1, t+1):
    n, k = map(int, input().split())
    numbers = list(map(int, input().split()))

    numbers.sort(reverse=True)

    print(f'#{test_case}', sum(numbers[0:k]))