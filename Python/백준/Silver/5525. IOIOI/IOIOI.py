import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input()
p = 'IO' * n + 'I'
cnt = 0

for i in range(m-len(p)+1):
    if s[i:i+len(p)] == p:
        cnt += 1

print(cnt)