t = int(input())
for test_case in range(1, t+1):

    array = [list(map(int, input().split())) for _ in range(9)]

    result = 1
    for i in range(9):
        cnt_r = [0] * 10
        cnt_c = [0] * 10
        for j in range(9):
            cnt_r[array[i][j]] += 1
            cnt_c[array[j][i]] += 1

        for k in range(1, 10):
            if cnt_r[k] != 1:
                result = 0
                break
            if cnt_c[k] != 1:
                result = 0
                break

    for i in range(3):
        for j in range(3):
            cnt_x = [0] * 10
            for k in range(3):
                for l in range(3):
                    cnt_x[array[3*i+k][3*j+l]] += 1

            for k in range(1, 10):
                if cnt_x[k] != 1:
                    result = 0
                    break

    print(f'#{test_case}', result)