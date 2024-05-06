t = int(input())
for test_case in range(1, t+1):
    numbers = list(map(int, input().split()))
    array = set()
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            result = 0
            for k in range(len(numbers)):
                if i != j and j != k and i != k:
                    result = numbers[i] + numbers[j] + numbers[k]
                    array.add(result)

    sorted_array = sorted(array)
    print(f'#{test_case}', sorted_array[-5])