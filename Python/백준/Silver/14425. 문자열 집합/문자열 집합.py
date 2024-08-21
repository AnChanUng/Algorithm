n, m = map(int, input().split())

set_s = set(input() for _ in range(n))

cnt = 0
for i in range(m):
    word = input()
    if word in set_s:
        cnt += 1

print(cnt)