import sys
input = sys.stdin.readline

n, m = map(int, input().split())
state = list(map(int, input().split()))
for _ in range(m):
    a, b, c = map(int, input().split())

    if a == 1:
        state[b-1] = c

    elif a == 2:
        for j in range(b-1, c):
            if state[j] == 0:
                state[j] = 1
            elif state[j] == 1:
                state[j] = 0

    elif a == 3:
        for j in range(b-1, c):
            if state[j] == 1:
                state[j] = 0

    elif a == 4:
        for j in range(b-1, c):
            if state[j] == 0:
                state[j] = 1
print(*state)