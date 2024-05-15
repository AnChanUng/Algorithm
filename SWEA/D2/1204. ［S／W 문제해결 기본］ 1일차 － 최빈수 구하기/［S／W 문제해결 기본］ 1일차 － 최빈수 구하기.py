t = int(input())
for test_case in range(1, t+1):
    number = int(input())
    numbers = list(map(int, input().split()))

    dict = {}

    for grade in numbers:
        if grade in dict:
            dict[grade] += 1
        else:
            dict[grade] = 0
    
    mode = max(dict, key=dict.get)

    print(f'#{test_case}', mode)