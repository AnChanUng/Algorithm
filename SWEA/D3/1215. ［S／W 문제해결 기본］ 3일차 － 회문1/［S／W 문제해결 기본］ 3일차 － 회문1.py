t = 10
for test_case in range(1, 11):
    num = int(input())
    array = [list(input()) for _ in range(8)]
    cnt = 0
    for i in range(8):
        for j in range(8-num+1):
            result = ""
            result += ''.join(array[i][j:j+num])
            if result == result[::-1]:
                cnt += 1

            total = ""
            total += ''.join(array[k][i] for k in range(j, j+num))
            if total == total[::-1]:
                cnt += 1
    print(f'#{test_case}', cnt)