for test_case in range(1, 11):
    n = int(input())
    array = [list(map(int, input().split())) for _ in range(100)]
    max_garo = 0
    max_sero = 0
    cross = 0
    for i in range(100):
        garo = 0
        sero = 0
        for j in range(100):
            # 가로 최대, 세로최대, 대각선 최대 구하기 그중 최대값 출력
            garo += array[i][j]
            max_garo = max(garo, max_garo)
            sero += array[j][i]
            max_sero = max(sero, max_sero)
            if i == j:
                cross += array[i][j]

    result = max(max_garo, max_sero, cross)

    print(f'#{test_case}', result)