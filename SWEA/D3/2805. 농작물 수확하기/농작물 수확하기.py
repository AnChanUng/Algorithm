t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    array = [list(map(int, input())) for _ in range(n)]

    start = n // 2
    end = n // 2
    answer = 0
    for i in range(n):
        for j in range(start, end+1):
            answer += array[i][j]

        if i < n//2:
            start -= 1
            end += 1
        else:
            start += 1
            end -= 1

    print(f'#{test_case}', answer)