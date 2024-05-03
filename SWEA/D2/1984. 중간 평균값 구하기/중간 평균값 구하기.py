t = int(input())
for test_case in range(1, t+1):
    numbers = list(map(int, input().split()))

    numbers.remove(max(numbers))
    numbers.remove(min(numbers))
    array = []
    for i in numbers:
        array.append(i)

    result = round(sum(array) / 8)

    print(f'#{test_case}', result)