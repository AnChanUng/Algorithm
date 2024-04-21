board = input()

b = board.replace('XXXX', 'AAAA').replace("XX", "BB")

if 'X' in b:
    print(-1)
else:
    print(b)