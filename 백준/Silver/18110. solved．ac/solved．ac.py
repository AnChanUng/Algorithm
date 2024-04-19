import sys
input = sys.stdin.readline

def round_val(val):
    if val - int(val) >= 0.5:
        return int(val) + 1
    else:
        return int(val)

n = int(input())

if n == 0:
    print(0)
else:
    levels = []
    for _ in range(n):
        level = int(input())
        levels.append(level)

    levels.sort()
    updown = round_val(n * 0.15)

    result = 0
    cnt = 0
    for i in range(updown, n-updown):
        result += levels[i]
        cnt += 1

    print(round_val(result / cnt))