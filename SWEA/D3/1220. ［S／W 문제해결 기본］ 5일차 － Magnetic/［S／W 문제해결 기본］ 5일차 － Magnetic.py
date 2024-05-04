for test_case in range(1, 11):
    n = int(input())  # 정사각형의 한변의 길이
    array = [list(map(int, input().split())) for _ in range(n)]

    count = 0
    for i in range(n):
        state = 0
        for j in range(n):

            if array[j][i] == 1 and state == 0:
                state = 1
            elif array[j][i] == 2 and state == 1:
                state = 0
                count += 1

    print(f'#{test_case}', count)