a = int(input())
t = int(input())
s = int(input())

bcount = 0
gcount = 0

cnt = 0
n = []

while True:
    cnt += 1
    for _ in range(2):
        bcount += 1
        n.append((bcount, 0))
        gcount += 1
        n.append((gcount, 1))
    for _ in range(cnt+1):
        bcount += 1
        n.append((bcount, 0))
    for _ in range(cnt+1):
        gcount += 1
        n.append((gcount, 1))

    if bcount >= t:
        print(n.index((t, s)) % a)
        break