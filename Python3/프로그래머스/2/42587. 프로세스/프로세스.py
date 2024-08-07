from collections import deque

def solution(priorities, location):
     
    deq = deque([(priority, idx) for idx, priority in enumerate(priorities)])
    cnt = 0
    
    while deq:
        current = deq.popleft()
        if any(current[0] < item[0] for item in deq):
            deq.append(current)
        else:
            cnt += 1
        
            if current[1] == location:
                return cnt
        