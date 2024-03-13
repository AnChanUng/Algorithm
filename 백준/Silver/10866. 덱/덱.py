import sys
from collections import deque
input = sys.stdin.readline

class Deque:
    def __init__(self):
        self.q = deque([])

    def push_front(self, x):
        self.q.appendleft(x)

    def push_back(self, x):
        self.q.append(x)

    def pop_front(self):
        if self.q:
            return self.q.popleft()
        else:
            return -1
            
    def pop_back(self):
        if self.q:
            return self.q.pop()
        else:
            return -1
        
    def size(self):
        return len(self.q)
        
    def empty(self):
        if not self.q:
            return 1
        else:
            return 0
        
    def front(self):
        if not self.q:
            return -1
        else:
            return self.q[0]
    
    def back(self):
        if not self.q:
            return -1
        else:
            return self.q[-1]

n = int(input())
deque_func = Deque()
for _ in range(n):
    cmd = list(input().split())

    if cmd[0] == 'push_front':
        deque_func.push_front(int(cmd[1]))
    elif cmd[0] == 'push_back':
        deque_func.push_back(int(cmd[1]))
    elif cmd[0] == 'pop_front':
        print(deque_func.pop_front())
    elif cmd[0] == 'pop_back':
        print(deque_func.pop_back())
    elif cmd[0] == 'size':
        print(deque_func.size())
    elif cmd[0] == 'empty':
        print(deque_func.empty())
    elif cmd[0] == 'front':
        print(deque_func.front())
    elif cmd[0] == 'back':
        print(deque_func.back())