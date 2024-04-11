n = int(input())
cnt = 0
li = []

for _ in range(n):
    cow, road = map(int, input().split())
    li.append([cow, road])

for i in range(n):
    for j in range(i+1,n):
        if li[i][0] == li[j][0]:
            if abs(li[i][1]- li[j][1]) == 0:
                break
            if abs(li[i][1] - li[j][1]) == 1:
                cnt += 1
                break

print(cnt)