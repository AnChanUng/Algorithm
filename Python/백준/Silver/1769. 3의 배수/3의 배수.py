import sys
input = sys.stdin.readline

x = list(map(int, input().rstrip()))

cnt = 0
while len(x) > 1:
    num = sum(x)
    x = list(map(int, str(num)))
    cnt += 1

print(cnt)

final_num = int(''.join(map(str, x)))
if final_num % 3 == 0:
    print("YES")
    
else:
    print("NO")