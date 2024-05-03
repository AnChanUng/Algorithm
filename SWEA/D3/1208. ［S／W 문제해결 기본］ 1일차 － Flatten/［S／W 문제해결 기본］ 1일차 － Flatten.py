t = 10
for test_case in range(1, t+1):
    dump = int(input())
    box_height = list(map(int, input().split()))

    for i in range(dump):

        box_height[box_height.index(max(box_height))] -= 1
        box_height[box_height.index(min(box_height))] += 1

    result = max(box_height) - min(box_height)
    print(f'#{test_case}', result)