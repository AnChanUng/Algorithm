t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    cards = list(input().split())

    if n % 2 == 0:
        up = []
        for a in range(n//2):
            up.append(cards[a])
        down = []
        for b in range(n//2, n):
            down.append(cards[b])
        array = []
        for i in range(n//2):
            array.append(up[i])
            array.append(down[i])
    else:
        up = []
        for a in range(n//2+1):
            up.append(cards[a])
        down = []
        for b in range(n//2+1, n):
            down.append(cards[b])

        array = []
        for i in range(n//2+1):
            if i <= n//2-1:
                array.append(up[i])
                array.append(down[i])
            else:
                array.append(up[i])

    print(f'#{test_case}', *array)
