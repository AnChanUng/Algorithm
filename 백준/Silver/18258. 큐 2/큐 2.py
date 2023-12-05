import sys
from collections import deque

# 비어있는 큐 만들기
queue = deque()
N = int(input())

for i in range(N):
    x = sys.stdin.readline().split()

    if x[0] == 'push':
        queue.append(int(x[1]))
    elif x[0] == 'pop':
        if not queue:
            print(-1)
        else:
            print(queue[0])
            queue.popleft()
    elif x[0] == 'size':
        print(len(queue))
    elif x[0] == 'empty':
        if len(queue) == 0:
            print(1)
        else:
            print(0)
    elif x[0] == 'front':
        if not queue:
            print(-1)
        else:
            print(queue[0])
    elif x[0] == 'back':
        if not queue:
            print(-1)
        else:
            print(queue[-1])
