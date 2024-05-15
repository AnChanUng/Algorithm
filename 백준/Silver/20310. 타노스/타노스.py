s = list(map(int, input()))

for _ in range(s.count(0)//2):
    s.remove(0) 

for _ in range(s.count(1) // 2):
    s.remove(1)

s.sort()

print(*s, sep="")