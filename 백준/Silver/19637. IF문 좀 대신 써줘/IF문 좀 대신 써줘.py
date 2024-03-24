import sys
input = sys.stdin.readline

n, m = map(int, input().split())  # 칭호수, 캐릭터수
titles = []
for _ in range(n):
    name, power = input().split()
    titles.append((name, int(power)))

titles.sort(key=lambda x: x[1])

for _ in range(m):
    charactor_power = int(input())
    left, right = 0, n - 1
    while left <= right:
        mid = (left + right) // 2
        if titles[mid][1] < charactor_power:
            left = mid + 1
        else:
            right = mid - 1
    print(titles[left][0])
