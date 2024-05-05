t = int(input())

for test_case in range(1, t + 1):
    n = int(input())
    array = [list(input()) for _ in range(n)]
    flag = 0

    for i in range(n):
        for j in range(n):
            # 수평 확인
            if j + 4 < n and array[i][j:j+5] == ['o']*5:
                flag = 1
                break
            
            # 수직 확인
            if i + 4 < n and all(array[i+k][j] == 'o' for k in range(5)):
                flag = 1
                break
            
            # 대각선 확인
            if i + 4 < n and j + 4 < n and all(array[i+k][j+k] == 'o' for k in range(5)):
                flag = 1
                break
            
            # 반대 대각선 확인
            if i + 4 < n and j - 4 >= 0 and all(array[i+k][j-k] == 'o' for k in range(5)):
                flag = 1
                break

    if flag == 1:
        print(f'#{test_case} YES')
    else:
        print(f'#{test_case} NO')