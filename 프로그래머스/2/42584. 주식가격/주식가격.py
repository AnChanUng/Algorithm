from collections import deque

def solution(prices):
    
    queue = deque(prices)
    answer = []
    while queue:
        current_price = queue.popleft()
        time = 0
        for price in queue:
            time += 1
            if current_price > price:
                break
        answer.append(time)
    return answer