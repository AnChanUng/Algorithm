from collections import deque
import sys
input = sys.stdin.readline

qq = deque([])
n = int(input())

for i in range(n):
    command = input().split()

    if command[0] == 'push':
        qq.append(int(command[1]))
    elif command[0] == 'pop':
        if len(qq) == 0:
            print(-1)
        else:
            print(qq.popleft())
    elif command[0] == 'size':
        print(len(qq))
    elif command[0] == 'empty':
        if len(qq) == 0:
            print(1)
        else:
            print(0)
    elif command[0] == 'front':
        if len(qq) == 0:
            print(-1)
        else:
            print(qq[0])
    elif command[0] == 'back':
        if len(qq) == 0:
            print(-1)
        else:
            print(qq[-1])