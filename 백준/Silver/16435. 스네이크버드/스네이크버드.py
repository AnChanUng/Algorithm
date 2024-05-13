n, l = map(int, input().split())
height = list(map(int, input().split()))
height.sort()

for i in range(n):
    if l >= height[i]:
        l += 1
    else:
        continue

print(l)