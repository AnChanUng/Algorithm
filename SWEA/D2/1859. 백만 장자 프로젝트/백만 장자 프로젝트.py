t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    numbers = list(map(int, input().split()))

    result = 0
    total = 0
    for i in numbers[::-1]:
        if i > result:
            result = i
        else:
            total += result - i
    
    print(f'#{test_case}', total)