t = int(input())
for i in range(1, t+1):
    money = int(input())
    cnt = [0, 0, 0, 0, 0, 0, 0, 0]
    while money > 0:
        if money >= 50000:
            cnt[0] += money // 50000
            money %= 50000
        elif money >= 10000:
            cnt[1] += money // 10000
            money %= 10000
        elif money >= 5000:
            cnt[2] += money // 5000
            money %= 5000
        elif money >= 1000:
            cnt[3] += money // 1000
            money %= 1000
        elif money >= 500:
            cnt[4] += money // 500
            money %= 500
        elif money >= 100:
            cnt[5] += money // 100
            money %= 100
        elif money >= 50:
            cnt[6] += money // 50
            money %= 50
        elif money >= 10:
            cnt[7] += money // 10
            money %= 10
        else:
            break
    print(f'#{i}')
    print(*cnt)