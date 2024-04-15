n, m = map(int, input().split())
chess_board = []
for _ in range(n):
    bw = input()
    chess_board.append(bw)

count = []
for a in range(n-7):
    for b in range(m-7):
        index1 = 0
        index2 = 0
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i+j) % 2 == 0:
                    if chess_board[i][j] != "W":
                        index1 += 1
                    if chess_board[i][j] != "B":
                        index2 += 1
                else:
                    if chess_board[i][j] != 'B':
                        index1 += 1
                    if chess_board[i][j] != "W":
                        index2 += 1
        count.append(min(index1, index2))

print(min(count))
