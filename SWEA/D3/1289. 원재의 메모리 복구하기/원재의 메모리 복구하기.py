t = int(input())
for test_case in range(1, t+1):
    bit = list(input())
    n = ['0'] * len(bit)
    cnt = 0
    for i in range(len(n)):
        if n[i] != bit[i]:
            n[i:] = bit[i] * len(n[i:])
            cnt += 1

    print(f'#{test_case}', cnt)