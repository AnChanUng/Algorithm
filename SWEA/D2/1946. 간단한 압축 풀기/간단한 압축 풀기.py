t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    array = []
    result = ""
    for _ in range(n):
        alpha, number = input().split()
        number = int(number)

        result += alpha * number
    print(f'#{test_case}')
    for i in range(0, len(result), 10):
        print(result[i:i+10])