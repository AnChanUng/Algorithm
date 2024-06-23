from collections import deque

def solution(cacheSize, cities):
    answer = 0
    
    cache = deque()
    
    for i in range(len(cities)):
        cities[i] = cities[i].upper()
        
        if cities[i] in cache:
            answer += 1
            cache.remove(cities[i])
            cache.appendleft(cities[i])
        else:
            answer += 5
            cache.appendleft(cities[i])
            
            if len(cache) > cacheSize:
                cache.pop()
    
    return answer
            