import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = set()
for _ in range(n):
    array.add(input().strip())

for _ in range(m):
    key_set = set(input().strip().split(','))
    array -= key_set
    print(len(array))