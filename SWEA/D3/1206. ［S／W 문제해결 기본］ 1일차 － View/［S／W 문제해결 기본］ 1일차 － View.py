t = 10
for test_case in range(1, t+1):
    number = int(input())
    height = list(map(int, input().split()))
    total = 0
    for i in range(2, len(height)-2):
        if height[i] > height[i-1] and height[i] > height[i-2] and height[i] > height[i+1] and height[i] > height[i+2]:
            total += height[i] - max(height[i-2],
                                     height[i-1], height[i+1], height[i+2])

    print(f'#{test_case}', total)
