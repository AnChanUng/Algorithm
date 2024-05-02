t = int(input())
for test_case in range(1, t+1):
    n, k = map(int, input().split())
    array = [list(map(int, input().split())) for _ in range(n)]
    result = 0
    for i in range(n):
        sum = 0
        for j in range(n):
            if array[i][j] == 1:
                sum += 1
            if array[i][j] == 0 or j == n-1:  # 0이거나 인덱스 끝에 도달하면 sum의 숫자 확인
                if sum == k:
                    result += 1
                sum = 0

    for i in range(n):
        sum = 0
        for j in range(n):
            if array[j][i] == 1:
                sum += 1
            if array[j][i] == 0 or j == n-1:
                if sum == k:
                    result += 1
                sum = 0

    print(f'#{test_case}', result)