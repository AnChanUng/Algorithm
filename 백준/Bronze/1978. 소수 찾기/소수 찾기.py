n = int(input())
sosu_number = list(map(int, input().split()))
cnt = 0

for x in sosu_number:
    for i in range(2, x+1):
        if x % i == 0:
            if x == i:
                cnt += 1
            break

print(cnt)