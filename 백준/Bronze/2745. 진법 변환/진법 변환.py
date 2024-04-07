a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
b, c = input().split()
b = b[::-1]
ans = 0
for i in range(len(b)):
    ans += a.find(b[i]) * int(c) ** i

print(ans)