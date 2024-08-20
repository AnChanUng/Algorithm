n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
answer = []
visited = [0] * n

def backtracking(start):
    if len(answer) == m:
        print(*answer)
        return
    
    remember = 0
    for i in range(n):
        if not visited[i] and remember != numbers[i]:
            if i >= start:
                visited[i] = True
                answer.append(numbers[i])
                remember = numbers[i]
                backtracking(i)
                answer.pop()
                visited[i] = False
                
backtracking(0)