t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    array = [0] * 5001
    
    for _ in range(n):
        a, b = map(int, input().split())
        for i in range(a, b+1):
            array[i] += 1

    p = int(input())

    p_array = []
    for i in range(p):
        c = int(input())
        p_array.append(c)

    
    print('#{}'.format(test_case), end=' ')
    for i in p_array:
        print(array[i], end=' ')
    print()