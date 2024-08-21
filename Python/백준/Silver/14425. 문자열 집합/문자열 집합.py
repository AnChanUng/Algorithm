n, m = map(int, input().split())
set_s = set()
for _ in range(n):
    word = input()
    set_s.add(word) 

cnt = 0
for i in range(m):
    word = input()
    if word in set_s:
        cnt += 1

print(cnt)