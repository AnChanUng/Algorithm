from collections import deque

for test_case in range(1, 11):
    n = int(input())
    array = map(int, input().split())
    queue = deque(array)
    i = 0
    while queue:
        i += 1
        if queue[0] >= 1:
            if i % 5 == 1:
                queue[0] -= 1
                queue.append(queue.popleft())
            elif i % 5 == 2:
                queue[0] -= 2
                queue.append(queue.popleft())
            elif i % 5 == 3:
                queue[0] -= 3
                queue.append(queue.popleft())
            elif i % 5 == 4:
                queue[0] -= 4
                queue.append(queue.popleft())
            elif i % 5 == 0:
                queue[0] -= 5
                queue.append(queue.popleft())
        if queue[-1] <= 0:
            queue[-1] = 0
            break

    print(f'#{test_case}', *queue)