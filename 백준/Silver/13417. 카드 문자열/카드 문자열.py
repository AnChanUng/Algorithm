from collections import deque

t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    cards = list(input().split())
    queue = deque()

    for i in cards:
        if len(queue) == 0:
            queue.append(i)
        elif ord(i) > ord(queue[0]):
            queue.append(i)
        else:
            queue.appendleft(i)
    
    print(*queue, sep="")