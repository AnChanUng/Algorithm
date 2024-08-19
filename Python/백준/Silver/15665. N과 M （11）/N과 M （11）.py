n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
visited = [False] * n
answer = []

def backtracking(k):
    
    if k == m:
        print(*answer)
        return
    
    remember = 0
    for i in range(n):
        if not visited[i] and remember != numbers[i]:
            answer.append(numbers[i])
            remember = numbers[i]
            backtracking(k+1)
            visited[i] = False
            answer.pop()

backtracking(0)