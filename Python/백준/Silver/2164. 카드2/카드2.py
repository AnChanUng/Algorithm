from collections import deque

n = int(input())

numbers = [i for i in range(1, n+1)]

queue = deque(numbers)

while len(queue) != 1:
    queue.popleft()
    queue.append(queue.popleft())

print(queue[0])