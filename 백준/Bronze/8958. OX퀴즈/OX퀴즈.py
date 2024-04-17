t = int(input())

for _ in range(t):
    quiz = input()
    cnt = 0
    total = 0
    for i in range(len(quiz)):
        if quiz[i] == "O":
            cnt += 1
            total += cnt

        else:
            cnt = 0
    print(total)
